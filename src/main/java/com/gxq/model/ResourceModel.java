package com.gxq.model;

import com.gxq.model.base.BaseModel;

import java.io.Serializable;

/**
 * Created by xuenianxiang on 2017/4/7.
 */
public class ResourceModel extends BaseModel implements Serializable {


    private String name;

    private String title;

    private int state;

    private int type;

    private String address;

    private Integer time;

    private String note;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
