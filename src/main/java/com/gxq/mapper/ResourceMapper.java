package com.gxq.mapper;

import com.gxq.model.ResourceModel;
import com.gxq.model.ResourceSearchModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by xuenianxiang on 2017/4/7.
 */

@Mapper
public interface ResourceMapper {

    int insert(ResourceModel resourceModel);

    int update(ResourceModel resourceModel);

    int updateState(ResourceModel resourceModel);

    List<ResourceModel> selectAll(ResourceSearchModel model);

    Long delete(List list);
}
