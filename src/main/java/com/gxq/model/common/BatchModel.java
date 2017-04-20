package com.gxq.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/8.
 */
public class BatchModel implements Serializable {

    private List<Long> list;

    private String createOne;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public String getCreateOne() {
        return createOne;
    }

    public void setCreateOne(String createOne) {
        this.createOne = createOne;
    }
}
