package com.gxq.model;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
public class DistributionInsertModel implements Serializable {

    private Integer packageId;

    private List<Integer> deviceIds;

    private String startTime;

    private String endTime;

    private String createOne;

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
        this.packageId = packageId;
    }

    public List<Integer> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(List<Integer> deviceIds) {
        this.deviceIds = deviceIds;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getCreateOne() {
        return createOne;
    }

    public void setCreateOne(String createOne) {
        this.createOne = createOne;
    }
}
