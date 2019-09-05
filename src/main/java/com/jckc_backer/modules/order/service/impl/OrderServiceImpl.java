package com.jckc_backer.modules.order.service.impl;


import com.jckc_backer.modules.order.entity.OrderDetailEntity;
import com.jckc_backer.modules.order.entity.OrderEntity;
import com.jckc_backer.modules.order.mapper.OrderMapper;
import com.jckc_backer.modules.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 17:26
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class OrderServiceImpl  implements OrderService {

    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<OrderEntity> getOrderList() {
        List<OrderEntity> orderList = orderMapper.getOrderList();
        return orderList;
    }

    @Override
    public List<OrderEntity> searchOrderList(String searchName) {
        List<OrderEntity> orderEntities = orderMapper.searchOrderList(searchName);
        return orderEntities;
    }

    /*@Override
    public List<OrderDetailEntity> getOrderDetailList(Integer id) {
        List<OrderDetailEntity> orderDetailList = orderMapper.getOrderDetailList(id);
        return orderDetailList;
    }*/
}
