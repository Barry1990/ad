package com.gxq.model.distribution;

import io.swagger.models.auth.In;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
public class DistributionInsertModel implements Serializable {

    private Long packageId;

    private List<Long> deviceIds;

    private String startTime;

    private String endTime;

    private String createOne;

    private Boolean atonce;

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public List<Long> getDeviceIds() {
        return deviceIds;
    }

    public void setDeviceIds(List<Long> deviceIds) {
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

    public Boolean getAtonce() {
        return atonce;
    }

    public void setAtonce(Boolean atonce) {
        this.atonce = atonce;
    }
}
