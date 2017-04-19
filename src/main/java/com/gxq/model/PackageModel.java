package com.gxq.model;

import com.gxq.model.base.BaseModel;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
public class PackageModel extends BaseModel implements Serializable {

    private String name;

    private String title;

    private int state;

    private String note;

    private List<Long> resourceIds;

    private List resources;

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

    public List<Long> getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(List<Long> resourceIds) {
        this.resourceIds = resourceIds;
    }

    public List getResources() {
        return resources;
    }

    public void setResources(List resources) {
        this.resources = resources;
    }
}
