package com.jckc_backer.modules.order.mapper;


import com.jckc_backer.modules.order.entity.OrderEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/8/13 16:27
 * @description：
 * @modified By：
 * @version:
 */

public interface OrderMapper  {

    public List<OrderEntity> getOrderList();

    public List<OrderEntity> searchOrderList(@Param(value = "searchName") String searchName);
}
