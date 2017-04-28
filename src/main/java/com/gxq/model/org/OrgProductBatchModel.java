package com.gxq.model.org;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/24.
 */
public class OrgProductBatchModel {

    private Integer wxthirdScale;

    private Integer alithirdScale;

    private String createOne;

    private List<OrgProductIdModel> list;

    public Integer getWxthirdScale() {
        return wxthirdScale;
    }

    public void setWxthirdScale(Integer wxthirdScale) {
        this.wxthirdScale = wxthirdScale;
    }

    public Integer getAlithirdScale() {
        return alithirdScale;
    }

    public void setAlithirdScale(Integer alithirdScale) {
        this.alithirdScale = alithirdScale;
    }

    public String getCreateOne() {
        return createOne;
    }

    public void setCreateOne(String createOne) {
        this.createOne = createOne;
    }

    public List<OrgProductIdModel> getList() {
        return list;
    }

    public void setList(List<OrgProductIdModel> list) {
        this.list = list;
    }
}
