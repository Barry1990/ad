package com.gxq.model;

import com.gxq.model.common.SearchModel;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/11.
 */
public class PublishSearchModel extends SearchModel {

    private List passIds;

    public List getPassIds() {
        return passIds;
    }

    public void setPassIds(List passIds) {
        this.passIds = passIds;
    }
}
