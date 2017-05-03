package com.gxq.service;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.google.gson.Gson;
import com.gxq.mapper.OrderMapper;
import com.gxq.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by xuenianxiang on 2017/4/27.
 */

@Service
public class OrderService {

    //微信转账
    private static final String TRANSFERS_PAY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/promotion/transfers"; // 企业付款

    private static final String TRANSFERS_PAY_QUERY = "https://api.mch.weixin.qq.com/mmpaymkttransfers/gettransferinfo"; // 企业付款查询

    private static final String APP_ID = ConfigUtil.getProperty("wx.appid");

    private static final String MCH_ID = ConfigUtil.getProperty("wx.mchid");

    private static final String API_SECRET = ConfigUtil.getProperty("wx.api.secret");


    @Autowired
    private OrderMapper orderMapper;

    /**
     * 后台作业(每日凌晨把efan的交易记录计算并插入t_order_status)
     * @return
     */
    public int insertOrderStatus(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        String serverDate = df.format(new Date());

        return orderMapper.insertOrderStatus(serverDate);
    }

    public void pay(){

        //查询

        //支付

        //更新表

    }

    public void alipay(String account, float amount){

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();

        Map<String, String> parm = new HashMap<String, String>();
        parm.put("out_biz_no", PayUtil.getTransferNo());
        parm.put("payee_type", "ALIPAY_LOGONID");
        parm.put("payee_account", account);
        parm.put("amount", amount+"");
        parm.put("payer_show_name", "Efan支付宝转账");
        parm.put("payee_real_name", "地主");
        parm.put("remark", "转账备注");

        request.setBizContent(new Gson().toJson(parm));

        try {
            AlipayFundTransToaccountTransferResponse response = alipayClient.execute(request);
            if(response.isSuccess()){
                System.out.println("调用成功");
            } else {
                System.out.println("调用失败");
            }
        }catch (Exception e){
            System.out.println("调用失败");
        }

    }

    public void wxpay(String openid,float amount){

        Map<String, String> restmap = null;

        try {
            Map<String, String> parm = new HashMap<String, String>();
            parm.put("mch_appid", APP_ID); //公众账号appid
            parm.put("mchid", MCH_ID); //商户号
            parm.put("nonce_str", PayUtil.getNonceStr()); //随机字符串
            parm.put("partner_trade_no", PayUtil.getTransferNo()); //商户订单号
            parm.put("openid", openid); //用户openid
            parm.put("check_name", "NO_CHECK"); //校验用户姓名选项 OPTION_CHECK
            parm.put("amount", amount+""); //转账金额
            parm.put("desc", "Efan微信转账"); //企业付款描述信息
            parm.put("spbill_create_ip", getV4IP()); //Ip地址
            parm.put("sign", PayUtil.getSign(parm, API_SECRET));

            String restxml = HttpUtils.posts(TRANSFERS_PAY, XmlUtil.xmlFormat(parm, false));
            restmap = XmlUtil.xmlParse(restxml);
        } catch (Exception e) {
            //error
        }

        if (CollectionUtil.isNotEmpty(restmap) && "SUCCESS".equals(restmap.get("result_code"))) {
            //LOG.info("转账成功：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            Map<String, String> transferMap = new HashMap<>();
            transferMap.put("partner_trade_no", restmap.get("partner_trade_no"));//商户转账订单号
            transferMap.put("payment_no", restmap.get("payment_no")); //微信订单号
            transferMap.put("payment_time", restmap.get("payment_time")); //微信支付成功时间

        }else {
            if (CollectionUtil.isNotEmpty(restmap)) {
                //LOG.info("转账失败：" + restmap.get("err_code") + ":" + restmap.get("err_code_des"));
            }
        }
    }

    //获取公网ip
    public static String getV4IP(){
        String ip = "";
        String chinaz = "http://ip.chinaz.com";

        StringBuilder inputLine = new StringBuilder();
        String read = "";
        URL url = null;
        HttpURLConnection urlConnection = null;
        BufferedReader in = null;
        try {
            url = new URL(chinaz);
            urlConnection = (HttpURLConnection) url.openConnection();
            in = new BufferedReader( new InputStreamReader(urlConnection.getInputStream(),"UTF-8"));
            while((read=in.readLine())!=null){
                inputLine.append(read+"\r\n");
            }
            //System.out.println(inputLine.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(in!=null){
                try {
                    in.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        Pattern p = Pattern.compile("\\<dd class\\=\"fz24\">(.*?)\\<\\/dd>");
        Matcher m = p.matcher(inputLine.toString());
        if(m.find()){
            String ipstr = m.group(1);
            ip = ipstr;
        }
        return ip;
    }

}
