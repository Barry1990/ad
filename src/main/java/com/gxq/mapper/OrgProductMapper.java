package com.gxq.mapper;

import com.gxq.model.org.OrgProductModel;
import com.gxq.model.org.OrgProductSearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/24.
 */

@Mapper
public interface OrgProductMapper {

    OrgProductModel selectByModel(OrgProductModel model);

    List<OrgProductModel> selectOrgProcuct(OrgProductSearchModel searchModel);

    Long selectAlreadyCount(OrgProductSearchModel searchModel);

    Long selectTotalCount(OrgProductSearchModel searchModel);

    int insert(OrgProductModel model);

    int insertHistory(OrgProductModel model);

    int update(OrgProductModel model);

    int updateHistory(OrgProductModel model);
}
