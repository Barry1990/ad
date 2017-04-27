package com.gxq.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by xuenianxiang on 2017/4/25.
 */

@Mapper
public interface OrderMapper {

    int insertOrderStatus(String serverDate);

}
