package com.gxq.service;

import com.gxq.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by xuenianxiang on 2017/4/27.
 */

@Service
public class OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 后台作业(每日凌晨把efan的交易记录计算并插入t_order_status)
     * @return
     */
    public int insertOrderStatus(){

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式

        String serverDate = df.format(new Date());

        return orderMapper.insertOrderStatus(serverDate);
    }

}
