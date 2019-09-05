package com.jckc_backer.modules.order.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.order.entity.OrderEntity;
import com.jckc_backer.modules.order.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:02
 * @description：
 * @modified By：
 * @version:
 */

@RestController
@Api(tags = "公告")
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 获取订单
     * @return
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseUtil getOrderList(int pageNo, int pageSize){
        PageHelper.startPage(pageNo, pageSize);
        List<OrderEntity> orderList = orderService.getOrderList();
        PageInfo<OrderEntity> pageInfo = new PageInfo<>(orderList);
        return ResponseUtil.success(pageInfo);
    }

    /**
     * 获取订单詳情
     * @return
     *//*
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public ResponseUtil getOrderDetail(int id){

        List<OrderDetailEntity> orderList = orderService.getOrderDetailList(id);

        return ResponseUtil.success(orderList);
    }*/

    /**
     * 模糊查询订单
     * @return
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ResponseUtil searchOrderList(int pageNo, int pageSize, String searchName){
        PageHelper.startPage(pageNo, pageSize);
        List<OrderEntity> orderList = orderService.searchOrderList(searchName);
        PageInfo<OrderEntity> pageInfo = new PageInfo<>(orderList);
        return ResponseUtil.success(pageInfo);
    }

    /**
     * 更新订单快递
     * @return
     */
    @RequestMapping(value = "/goods/update", method = RequestMethod.POST)
    public ResponseUtil updateOrderGoods(int id, String  logisticsCompany, String logisticsOrderOn){
        orderService.updateOrderGoods(id, logisticsCompany, logisticsOrderOn);
        return ResponseUtil.success();
    }




}
