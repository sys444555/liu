package com.jckc_backer.modules.order.service.impl;


import com.jckc_backer.common.exception.JcException;
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

    @Override
    public void updateOrderGoods(Integer id, String logisticsCompany, String logisticsOrderOn) {
        Integer result = orderMapper.updateOrderGoods(id, logisticsCompany, logisticsOrderOn);
        if(result == null || result != 1){
            throw new JcException("更新快递单号失败");
        }
    }


}
