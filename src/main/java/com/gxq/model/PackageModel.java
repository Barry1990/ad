package com.gxq.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
public class PackageModel implements Serializable {

    private Integer id;

    private String name;

    private String title;

    private int state;

    private String note;

    private String isDelete;

    private String createOne;

    private String createTime;

    private String updateOne;

    private String updateTime;

    private List resourceIds;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateOne() {
        return createOne;
    }

    public void setCreateOne(String createOne) {
        this.createOne = createOne;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateOne() {
        return updateOne;
    }

    public void setUpdateOne(String updateOne) {
        this.updateOne = updateOne;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public List getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List resourceIds) {
        this.resourceIds = resourceIds;
    }
}
