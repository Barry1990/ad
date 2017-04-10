package com.gxq.service;

import com.gxq.mapper.PackageMapper;
import com.gxq.model.PackageModel;
import com.gxq.model.ResourceModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
@Service
public class PackageService {

    @Autowired
    private PackageMapper packageMapper;

    @Transactional
    public ModelMap insert(PackageModel packageModel){

        ModelMap result = new ModelMap();

        packageMapper.insertPackage(packageModel);

        packageMapper.insertPackage_Resource(packageModel);

        result.put("result", "1");

        result.put("errorMsg", "添加成功!");

        return result;
    }
}
