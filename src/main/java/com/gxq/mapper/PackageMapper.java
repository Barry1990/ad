package com.gxq.mapper;

import com.gxq.model.ChangeStateModel;
import com.gxq.model.PackageModel;
import com.gxq.model.ResourceModel;
import com.gxq.model.SearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/10.
 */
@Mapper
public interface PackageMapper {

    /**
     * 查询所有资源包
     * @param model
     * @return
     */
    List<PackageModel> selectAll(SearchModel model);

    /**
     * 插入资源包主表
     * @param packageModel
     * @return
     */
    int insertPackage(PackageModel packageModel);

    /**
     * 批量删除资源包(逻辑删除)
     * @param list
     * @return
     */
    int deletePackage(List list);

    /**
     * 批量更新资源包发布状态(0:未发布,1:已发布)
     * @param model
     * @return
     */
    int updateState(ChangeStateModel model);

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

    /**
     * 更新资源包主表
     * @param packageModel
     * @return
     */
    int updatePackage(PackageModel packageModel);

    /**
     * 删除从表
     * @param id
     * @return
     */
    int deletePackage_Resource(Long id);

}
