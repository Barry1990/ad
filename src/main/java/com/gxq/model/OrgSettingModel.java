package com.gxq.model;

import com.gxq.model.base.BaseModel;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/18.
 */
public class OrgSettingModel extends BaseModel implements Serializable {

    /**
     * 组织ID
     */
    private Long orgId;

    /**
     * 组织名称
     */
    private String orgName;

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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

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
