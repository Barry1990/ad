package com.gxq.model.pay;

/**
 * Created by xuenianxiang on 2017/5/3.
 */
public class WXPayModel {

    // 公众账号
    private String mch_appid;

    // 商户号
    private String mchid;

    // 随机字符串
    private String nonce_str;

    // 商户订单号
    private String partner_trade_no;

    // 用户openid
    private String openid;

    // 校验用户姓名选项  NO_CHECK：不校验真实姓名
    private String check_name;

    // 付款金额
    private int amount;

    // 企业付款描述信息
    private String desc;

    // 调用接口的机器Ip地址
    private String spbill_create_ip;

    // 签名
    private String sign;

    public String getMch_appid() {
        return mch_appid;
    }

    public void setMch_appid(String mch_appid) {
        this.mch_appid = mch_appid;
    }

    public String getMchid() {
        return mchid;
    }

    public void setMchid(String mchid) {
        this.mchid = mchid;
    }

    public String getNonce_str() {
        return nonce_str;
    }

    public void setNonce_str(String nonce_str) {
        this.nonce_str = nonce_str;
    }

    public String getPartner_trade_no() {
        return partner_trade_no;
    }

    public void setPartner_trade_no(String partner_trade_no) {
        this.partner_trade_no = partner_trade_no;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getCheck_name() {
        return check_name;
    }

    public void setCheck_name(String check_name) {
        this.check_name = check_name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSpbill_create_ip() {
        return spbill_create_ip;
    }

    public void setSpbill_create_ip(String spbill_create_ip) {
        this.spbill_create_ip = spbill_create_ip;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}
