package com.gxq.model.org;

import com.gxq.model.base.BaseModel;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/18.
 */
@ExcelTarget("OrgSettingModel")
public class OrgSettingModel extends BaseModel implements Serializable {

    private Long orgId;

    @Excel(name = "对象", orderNum = "1", mergeVertical = false)
    private String orgName;

    @Excel(name = "收款账号（微信）", orderNum = "2", mergeVertical = false)
    private String  wxsmAccount;

    @Excel(name = "收款账号（支付宝）", orderNum = "3", mergeVertical = false)
    private String  alismAccount;

    @Excel(name = "分账账号（微信）", orderNum = "4", mergeVertical = false)
    private String wxAccount;

    @Excel(name = "分账账号（支付宝）", orderNum = "5", mergeVertical = false)
    private String aliAccount;

    /**
     * 周期类型(1.日结  2.月结)
     */
    private Integer periodType;

    /**
     * 周期
     */
    private Integer periodTime;

    @Excel(name = "周期", orderNum = "6", mergeVertical = false)
    private String periodDes;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
        this.setId(orgId);
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

    public String getWxsmAccount() {
        return wxsmAccount;
    }

    public void setWxsmAccount(String wxsmAccount) {
        this.wxsmAccount = wxsmAccount;
    }

    public String getAlismAccount() {
        return alismAccount;
    }

    public void setAlismAccount(String alismAccount) {
        this.alismAccount = alismAccount;
    }

    public String getPeriodDes() {

        if (this.getPeriodType()==1){
            return "T+"+this.getPeriodTime();
        }else if (this.getPeriodType()==2){
            return "次月"+this.getPeriodTime()+"日";
        }else {
            return "";
        }
    }

    public void setPeriodDes(String periodDes) {
        this.periodDes = periodDes;
    }
}
