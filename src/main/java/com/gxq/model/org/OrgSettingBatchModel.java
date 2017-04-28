package com.gxq.model.org;

import com.gxq.model.common.BatchModel;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/20.
 */
public class OrgSettingBatchModel extends BatchModel implements Serializable {

    /**
     * 微信分账账户
     */
    private String wxAccount;

    /**
     * 支付宝分账账户
     */
    private String aliAccount;

    /**
     * 周期类型(1.月结  2.日结)
     */
    private Integer periodType;

    /**
     * 周期
     */
    private Integer periodTime;


    public String getWxAccount() {
        return wxAccount;
    }

    public void setWxAccount(String wxAccount) {
        this.wxAccount = wxAccount;
    }

    public String getAliAccount() {
        return aliAccount;
    }

    public void setAliAccount(String aliAccount) {
        this.aliAccount = aliAccount;
    }

    public Integer getPeriodType() {
        return periodType;
    }

    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    public Integer getPeriodTime() {
        return periodTime;
    }

    public void setPeriodTime(Integer periodTime) {
        this.periodTime = periodTime;
    }
}
