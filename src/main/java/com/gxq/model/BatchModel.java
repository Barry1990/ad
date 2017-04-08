package com.gxq.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/8.
 */
public class BatchModel implements Serializable {

    private List list;

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }
}
