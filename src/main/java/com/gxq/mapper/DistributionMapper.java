package com.gxq.mapper;

import com.gxq.model.distribution.DistributionModel;
import com.gxq.model.distribution.DistributionRecordModel;
import com.gxq.model.MachineModel;
import com.gxq.model.MachineSearchModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.common.SearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */

@Mapper
public interface DistributionMapper {

    /**
     * 查询组织机构下设备
     * @param model
     * @return
     */
    List<MachineModel> selectOrgMachine(MachineSearchModel model);

    int updateState(ChangeStateModel model);

    int insertDistribution(DistributionModel model);

    int insertDistribution_Records(DistributionModel model);

    List<DistributionRecordModel> selectDistribution_Records(SearchModel model);
}
