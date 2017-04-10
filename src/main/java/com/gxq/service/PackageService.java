package com.gxq.service;

import com.gxq.mapper.PackageMapper;
import com.gxq.mapper.ResourceMapper;
import com.gxq.model.PackageModel;
import com.gxq.model.ResourceModel;
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
}
