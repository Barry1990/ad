package com.gxq.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/8.
 */
public class BatchModel implements Serializable {

    private List<Integer> list;

    public List<Integer> getList() {
        return list;
    }

    public void setList(List<Integer> list) {
        this.list = list;
    }
}
