package com.gxq.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/7.
 */
public class PageModel implements Serializable {

    private String result;

    private String errorCode;

    private List list;

    private long total;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }
}
