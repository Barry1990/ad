package com.gxq.service;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayFundTransToaccountTransferRequest;
import com.alipay.api.response.AlipayFundTransToaccountTransferResponse;
import com.gxq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuenianxiang on 2017/4/27.
 */

@Service
public class OrderService {

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

        AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do","app_id","your private_key","json","GBK","alipay_public_key","RSA2");
        AlipayFundTransToaccountTransferRequest request = new AlipayFundTransToaccountTransferRequest();
        request.setBizContent("{" +
                "    \"out_biz_no\":\"3142321423432\"," +
                "    \"payee_type\":\"ALIPAY_LOGONID\"," +
                "    \"payee_account\":\"abc@sina.com\"," +
                "    \"amount\":\"12.23\"," +
                "    \"payer_show_name\":\"上海交通卡退款\"," +
                "    \"payee_real_name\":\"张三\"," +
                "    \"remark\":\"转账备注\"," +
                "  }");

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

}
