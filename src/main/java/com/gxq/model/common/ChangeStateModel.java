package com.gxq.model.common;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/8.
 */
public class ChangeStateModel implements Serializable {

    private List<Long> list;

    private int state;

    public List<Long> getList() {
        return list;
    }

    public void setList(List<Long> list) {
        this.list = list;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
