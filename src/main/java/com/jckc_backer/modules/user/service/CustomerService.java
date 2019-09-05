package com.jckc_backer.modules.user.service;

import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.user.entity.CustomerEntity;

import java.util.List;

/**
 * @Author: Charles Chan
 * @Date: 2019/9/3 16:20
 * @Version 1.0
 */
public interface CustomerService extends IService<CustomerEntity> {

    List<CustomerEntity> getVipList();
}
