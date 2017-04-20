package com.gxq.mapper;

import com.gxq.model.OrgSettingBatchModel;
import com.gxq.model.OrgSettingModel;
import com.gxq.model.OrgSettingSearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/18.
 */

@Mapper
public interface OrgSettingMapper {

    List<OrgSettingModel> selectOrgAccountSetting(OrgSettingSearchModel searchModel);

    OrgSettingModel selectByOrgId(Long orgId);

    int insert(OrgSettingModel model);

    int insertHistory(OrgSettingBatchModel model);

    int update(OrgSettingModel model);

    int updateHistory(OrgSettingBatchModel model);
}
