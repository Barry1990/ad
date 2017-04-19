package com.gxq.mapper;

import com.gxq.model.OrgSettingModel;

/**
 * Created by xuenianxiang on 2017/4/18.
 */
public interface OrgSettingMapper {

    int insert(OrgSettingModel model);

    int insertHistory(OrgSettingModel model);

    int update(OrgSettingModel model);

    int updateHistory(OrgSettingModel model);
}
