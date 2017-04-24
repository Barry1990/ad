package com.gxq.model;

import com.gxq.model.base.BaseModel;

/**
 * Created by xuenianxiang on 2017/4/24.
 */
public class OrgProductModel extends BaseModel{

    private Long orgId;

    private String orgName;

    private Long productId;

    private String productName;

    private Integer wxthirdScale;

    private Integer alithirdScale;

    /**
     * 机器数量
     */
    private Integer machineCount;

    /**
     * 货道数量
     */
    private Integer boxCount;

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

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Integer getWxthirdScale() {
        return wxthirdScale;
    }

    public void setWxthirdScale(Integer wxthirdScale) {
        this.wxthirdScale = wxthirdScale;
    }

    public Integer getAlithirdScale() {
        return alithirdScale;
    }

    public void setAlithirdScale(Integer alithirdScale) {
        this.alithirdScale = alithirdScale;
    }

    public Integer getMachineCount() {
        return machineCount;
    }

    public void setMachineCount(Integer machineCount) {
        this.machineCount = machineCount;
    }

    public Integer getBoxCount() {
        return boxCount;
    }

    public void setBoxCount(Integer boxCount) {
        this.boxCount = boxCount;
    }
}
