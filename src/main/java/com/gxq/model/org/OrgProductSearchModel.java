package com.gxq.model.org;

/**
 * Created by xuenianxiang on 2017/4/24.
 */
public class OrgProductSearchModel {

    private Long orgId;

    private String orgName;

    private String isSetting;

    private int pageNum;

    private int pageSize;

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

    public String getIsSetting() {
        return isSetting;
    }

    public void setIsSetting(String isSetting) {
        this.isSetting = isSetting;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
