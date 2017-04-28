package com.gxq.mapper;

import com.gxq.model.ResourceDisModel;
import com.gxq.model.common.ChangeStateModel;
import com.gxq.model.PublishSearchModel;
import com.gxq.model.ResourceModel;
import com.gxq.model.common.SearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/7.
 */

@Mapper
public interface ResourceMapper {

    int insert(ResourceModel resourceModel);

    int update(ResourceModel resourceModel);

    int updateState(ChangeStateModel model);

    List<ResourceModel> selectAll(SearchModel model);

    List<ResourceModel> selectPublish(PublishSearchModel model);

    ResourceModel selectById(Long id);

    List<ResourceModel> selectResourceListByPackageId(Long id);

    Long delete(List list);


    /*-------------------------以下是为设备提供的接口------------------------------*/
    List<ResourceDisModel> selcectResourceByMachineId(Long machineId);

    int updateRecordById(Long id);
}
