package com.jckc_backer.modules.order.service;

import com.jckc_backer.modules.order.entity.OrderEntity;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/20 18:52
 * @description：
 * @modified By：
 * @version:
 */
public interface OrderService {

    public List<OrderEntity> getOrderList();

    public List<OrderEntity> searchOrderList(String searchName);

    //public List<OrderDetailEntity> getOrderDetailList(Integer id);

    public void updateOrderGoods(Integer id, String logisticsCompany, String logisticsOrderOn);
}
