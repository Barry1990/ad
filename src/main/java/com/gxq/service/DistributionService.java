package com.gxq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxq.mapper.DistributionMapper;
import com.gxq.model.distribution.DistributionInsertModel;
import com.gxq.model.distribution.DistributionModel;
import com.gxq.model.MachineSearchModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.common.SearchModel;
import com.gxq.model.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

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

        //校验设备
        if (distributionInsertModel.getDeviceIds().size() < 1){
            result.put("result", "0");
            result.put("errorMsg", "设备列表不能为空!");
            return result;
        }

        //检验时间
        if (distributionInsertModel.getAtonce() == false){
            if(distributionInsertModel.getStartTime() == null || distributionInsertModel.getStartTime().equals("")){
                result.put("result", "0");
                result.put("errorMsg", "开始时间不能为空!");
                return result;
            }
            if(distributionInsertModel.getEndTime() == null || distributionInsertModel.getEndTime().equals("")){
                result.put("result", "0");
                result.put("errorMsg", "结束时间不能为空!");
                return result;
            }
        }

        //先更新已存在的分发(state 设为 0)
        ChangeStateModel changeStateModel = new ChangeStateModel();
        changeStateModel.setState(0);
        changeStateModel.setList(distributionInsertModel.getDeviceIds());
        distributionMapper.updateState(changeStateModel);

        //插入分发表&记录表
        for (Long uid :distributionInsertModel.getDeviceIds()){
            DistributionModel model = new DistributionModel();
            model.setUid(uid);
            model.setPackageId(distributionInsertModel.getPackageId());
            model.setStartTime(distributionInsertModel.getStartTime());
            model.setEndTime(distributionInsertModel.getEndTime());
            model.setCreateOne(distributionInsertModel.getCreateOne());
            model.setUpdateOne(distributionInsertModel.getCreateOne());
            //分发表
            distributionMapper.insertDistribution(model);
            //记录表
            distributionMapper.insertDistribution_Records(model);
        }

        result.put("result", "1");
        result.put("errorMsg", "添加成功!");

        return result;
    }

    public PageModel selectOrgMachine(MachineSearchModel model){

        PageModel pageModel = new PageModel();

        Page page = PageHelper.startPage(model.getPageNum(),model.getPageSize());

        String name = model.getName();

        //name模糊查询
        if (name != null && name.length() > 0){
            model.setName("%" + name + "%");
        }else {
            model.setName(null);
        }

        List list = distributionMapper.selectOrgMachine(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        return pageModel;
    }


    public PageModel selectRecords(SearchModel model){
        PageModel pageModel = new PageModel();

        Page page = PageHelper.startPage(model.getPageNum(),model.getPageSize());

        String name = model.getName();
        String startTime = model.getStartTime();
        String endTime = model.getEndTime();

        //name模糊查询
        if (name != null && name.length() > 0){
            model.setName("%" + name + "%");
        }else {
            model.setName(null);
        }

        if (startTime != null && !(startTime.length()>0)){
            model.setStartTime(null);
        }

        if (endTime != null && !(endTime.length()>0)){
            model.setEndTime(null);
        }

        List list = distributionMapper.selectDistribution_Records(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        return pageModel;
    }

    @Transactional
    public ModelMap updateState(ChangeStateModel model){

        ModelMap result = new ModelMap();

        //校验
        if (model.getState() != 0 && model.getState() != 1){
            result.put("result", "0");
            result.put("errorMsg", "状态有误!");
            return result;
        }

        if (distributionMapper.updateState(model) > 0){
            result.put("result", "1");
            result.put("errorMsg", "更新成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "更新失败!");
        }

        return result;
    }


}
