package com.gxq.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.gxq.mapper.ResourceMapper;
import com.gxq.model.PageModel;
import com.gxq.model.ResourceModel;
import com.gxq.model.ResourceSearchModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/7.
 */

@Service
public class ResourceService {

    @Autowired
    private ResourceMapper resourceMapper;

    /**
     * 添加广告资源
     * @param resourceModel
     * @return
     */
    public ModelMap insert(ResourceModel resourceModel){

        ModelMap result = new ModelMap();

        if (resourceMapper.insert(resourceModel) > 0){
            result.put("result", "1");
            result.put("errorMsg", "添加成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "添加失败!");
        }

        return result;
    }

    /**
     * 删除广告资源
     * @param list
     * @return
     */
    public ModelMap delete(List list){

        ModelMap result = new ModelMap();

        if (resourceMapper.delete(list) > 0){
            result.put("result", "1");
            result.put("errorMsg", "删除成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "删除失败!");
        }

        return result;
    }

    /**
     * 更新广告资源
     * @param resourceModel
     * @return
     */
    public ModelMap update(ResourceModel resourceModel){

        ModelMap result = new ModelMap();

        if (resourceModel.getType()==2){

            if (resourceModel.getTime() == null){
                result.put("result", "0");
                result.put("errorMsg", "时长不能为空!");
                return result;
            }
        }

        if (resourceMapper.update(resourceModel) > 0){
            result.put("result", "1");
            result.put("errorMsg", "更新成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "更新失败!");
        }

        return result;
    }

    /**
     * 更新状态(发布、未发布)
     * @param resourceModel
     * @return
     */
    public ModelMap updateState(ResourceModel resourceModel){

        ModelMap result = new ModelMap();

        //校验
        if (resourceModel.getState() != 0 && resourceModel.getState() != 1){
            result.put("result", "0");
            result.put("errorMsg", "状态有误!");
            return result;
        }

        if (resourceMapper.updateState(resourceModel) > 0){
            result.put("result", "1");
            result.put("errorMsg", "更新成功!");
        }else {
            result.put("result", "0");
            result.put("errorMsg", "更新失败!");
        }

        return result;
    }

    /**
     * 查询广告资源列表
     * @param model
     * @return
     */
    public PageModel selectAll(ResourceSearchModel model) {

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

        List list = resourceMapper.selectAll(model);

        pageModel.setList(list);

        pageModel.setTotal(page.getTotal());

        return pageModel;
    }


    public ModelMap selectById(Long id) {

        ModelMap result = new ModelMap();

        ResourceModel model = resourceMapper.selectById(id);

        if (model != null){
            result.put("result", "1");
            result.put("errorMsg", "获取成功!");
            result.put("data", model);
        }else {
            result.put("result", "1");
            result.put("errorMsg", "获取失败!");
        }

        return result;
    }


}
