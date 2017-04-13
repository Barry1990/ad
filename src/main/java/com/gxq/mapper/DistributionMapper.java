package com.gxq.mapper;

import com.gxq.model.DistributionModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */

@Mapper
public interface DistributionMapper {

    int updateState(List list);

    int insertDistribution(DistributionModel model);

    int insertDistribution_Records(DistributionModel model);
}
