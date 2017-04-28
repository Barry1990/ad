package com.gxq.model.distribution;

import com.gxq.model.base.BaseModel;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
public class DistributionModel extends BaseModel implements Serializable {

    private Long uid;

    private Long packageId;

    private int state;

    private String startTime;

    private String endTime;

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public Long getPackageId() {
        return packageId;
    }

    public void setPackageId(Long packageId) {
        this.packageId = packageId;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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
}
