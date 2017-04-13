package com.gxq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxq.mapper.PackageMapper;
import com.gxq.mapper.ResourceMapper;
import com.gxq.model.*;
import com.gxq.model.common.SearchModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.page.PageModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
@Service
public class PackageService {

    @Autowired
    private PackageMapper packageMapper;

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 查询资源包列表
     * @param model
     * @return
     */
    public PageModel selectAll(SearchModel model) {

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

        List list = packageMapper.selectAll(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        return pageModel;
    }

    public PageModel selectPublish(SearchModel model) {

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

        List list = packageMapper.selectPublish(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        return pageModel;
    }

    /**
     * 添加资源包
     * @param packageModel
     * @return
     */
    @Transactional
    public ModelMap insert(PackageModel packageModel){

        ModelMap result = new ModelMap();

        packageMapper.insertPackage(packageModel);

        packageMapper.insertPackage_Resource(packageModel);

        result.put("result", "1");

        result.put("errorMsg", "添加成功!");

        return result;
    }

    /**
     * 查询资源包详情
     * @return
     */
    public ModelMap selectById(Long id){

        ModelMap result = new ModelMap();

        PackageModel packageModel = packageMapper.selectPackageById(id);

        List<ResourceModel> resourceList = resourceMapper.selectResouceListByPackageId(id);

        if (packageModel != null){
            packageModel.setResources(resourceList);
            result.put("result", "1");
            result.put("errorMsg", "获取成功!");
            result.put("data",packageModel);
        }else {
            result.put("result", "0");
            result.put("errorMsg", "获取失败!");
        }

        return result;
    }

    /**
     * 更新资源包
     * @param packageModel
     * @return
     */
    @Transactional
    public ModelMap update(PackageModel packageModel){

        ModelMap result = new ModelMap();

        //更新主表
        packageMapper.updatePackage(packageModel);

        //删除从表
        packageMapper.deletePackage_Resource(new Long((long)packageModel.getId()));

        //插入从表
        packageMapper.insertPackage_Resource(packageModel);

        result.put("result", "1");

        result.put("errorMsg", "更新成功!");

        return result;
    }

    /**
     * 批量删除广告资源(逻辑删除)
     * @param list
     * @return
     */
    @Transactional
    public ModelMap delete(List list){

        ModelMap result = new ModelMap();

        if (packageMapper.deletePackage(list) > 0){
            result.put("result", "1");
            result.put("errorMsg", "删除成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "删除失败!");
        }

        return result;
    }

    /**
     * 更新状态(发布、未发布)
     * @param model
     * @return
     */
    @Transactional
    public ModelMap updateState(ChangeStateModel model){

        ModelMap result = new ModelMap();

        //校验
        if (model.getState() != 0 && model.getState() != 1){
            result.put("result", "0");
            result.put("errorMsg", "状态有误!");
            return result;
        }

        if (packageMapper.updateState(model) > 0){
            result.put("result", "1");
            result.put("errorMsg", "更新成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "更新失败!");
        }

        return result;
    }

}
