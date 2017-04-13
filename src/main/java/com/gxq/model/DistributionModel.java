package com.gxq.model;

import com.gxq.model.base.BaseModel;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
public class DistributionModel extends BaseModel implements Serializable {

    private Integer uid;

    private Integer packageId;

    private int state;

    private String startTime;

    private String endTime;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getPackageId() {
        return packageId;
    }

    public void setPackageId(Integer packageId) {
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
