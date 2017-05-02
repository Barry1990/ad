package com.gxq.model.org;

import com.gxq.model.base.BaseModel;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecgframework.poi.excel.annotation.ExcelTarget;

/**
 * Created by xuenianxiang on 2017/4/24.
 */

@ExcelTarget("OrgProductModel")
public class OrgProductModel extends BaseModel{

    private Long orgId;

    @Excel(name = "对象", orderNum = "3", mergeVertical = false)
    private String orgName;

    @Excel(name = "商品Id", orderNum = "2", mergeVertical = false)
    private Long productId;

    @Excel(name = "商品名称", orderNum = "1", mergeVertical = false)
    private String productName;

    @Excel(name = "xxxx商贸（微信）%", orderNum = "6", mergeVertical = false)
    private Integer wxSmScale;

    @Excel(name = "xxxx商贸（支付宝）%", orderNum = "8", mergeVertical = false)
    private Integer aliSmScale;

    @Excel(name = "三方（微信）%", orderNum = "7", mergeVertical = false)
    private Integer wxthirdScale;

    @Excel(name = "三方（支付宝）%", orderNum = "9", mergeVertical = false)
    private Integer alithirdScale;

    @Excel(name = "机器数", orderNum = "4", mergeVertical = false)
    private Integer machineCount;

    @Excel(name = "货道数", orderNum = "5", mergeVertical = false)
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

    public Integer getWxSmScale() {
        return 100 - this.getWxthirdScale();
    }

    public void setWxSmScale(Integer wxSmScale) {
        this.wxSmScale = wxSmScale;
    }

    public Integer getAliSmScale() {
        return 100 - this.getAlithirdScale();
    }

    public void setAliSmScale(Integer aliSmScale) {
        this.aliSmScale = aliSmScale;
    }
}
