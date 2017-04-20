package com.gxq.model;

/**
 * Created by xuenianxiang on 2017/4/19.
 */
public class OrgSettingSearchModel {

    private Long orgId;

    private String isSetting;

    private int pageNum;

    private int pageSize;

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
