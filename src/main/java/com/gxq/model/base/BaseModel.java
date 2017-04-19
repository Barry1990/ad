package com.gxq.model.base;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
public class BaseModel {

    private Long id;

    private int isDelete;

    private String createOne;

    private String createTime;

    private String updateOne;

    private String updateTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
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
}
