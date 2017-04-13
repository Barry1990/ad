package com.gxq.mapper;

import com.gxq.model.DistributionModel;
import com.gxq.model.DistributionRecordModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.common.SearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */

@Mapper
public interface DistributionMapper {

    int updateState(ChangeStateModel model);

    int insertDistribution(DistributionModel model);

    int insertDistribution_Records(DistributionModel model);

    List<DistributionRecordModel> selectDistribution_Records(SearchModel model);
}
