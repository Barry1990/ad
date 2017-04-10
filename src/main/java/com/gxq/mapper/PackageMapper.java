package com.gxq.mapper;

import com.gxq.model.PackageModel;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
@Mapper
public interface PackageMapper {

    /**
     * 插入主表
     * @param packageModel
     * @return
     */
    int insertPackage(PackageModel packageModel);

    /**
     * 插入关系表
     * @param packageModel
     * @return
     */
    int insertPackage_Resource(PackageModel packageModel);

    /**
     * 查询资源包信息
     * @param id
     * @return
     */
    PackageModel selectPackageById(Long id);

}
