package com.gxq.model;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/28.
 */
public class ResourceDisModel implements Serializable {

    private Long recordId;

    private String name;

    private int type;

    private String address;

    private Integer time;

    public Long getRecordId() {
        return recordId;
    }

    public void setRecordId(Long recordId) {
        this.recordId = recordId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }
}
