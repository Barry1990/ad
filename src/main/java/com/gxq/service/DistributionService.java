package com.gxq.service;

import com.gxq.mapper.DistributionMapper;
import com.gxq.model.DistributionInsertModel;
import com.gxq.model.DistributionModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/13.
 */
@Service
public class DistributionService {

    @Autowired
    private DistributionMapper distributionMapper;

    /**
     * 分发
     * @param distributionInsertModel
     * @return
     */
    @Transactional
    public ModelMap insert(DistributionInsertModel distributionInsertModel){

        ModelMap result = new ModelMap();

        //先更新已存在的分发
        distributionMapper.updateState(distributionInsertModel.getDeviceIds());

        //插入
        for (Integer uid :distributionInsertModel.getDeviceIds()){
            DistributionModel model = new DistributionModel();
            model.setUid(uid);
            model.setPackageId(distributionInsertModel.getPackageId());
            model.setStartTime(distributionInsertModel.getStartTime());
            model.setEndTime(distributionInsertModel.getEndTime());
            model.setCreateOne(distributionInsertModel.getCreateOne());
            model.setUpdateOne(distributionInsertModel.getCreateOne());

            distributionMapper.insertDistribution(model);
            distributionMapper.insertDistribution_Records(model);
        }

        result.put("result", "1");
        result.put("errorMsg", "添加成功!");

        return result;
    }


}
