package com.jckc_backer.modules.user.controller;

import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.modules.user.entity.CustomerEntity;
import com.jckc_backer.modules.user.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Charles Chan
 * @Date: 2019/9/3 16:24
 * @Version 1.0
 */
@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping("/getVipList")
    public ResponseUtil getVipList(){
        List<CustomerEntity> userEntityList = customerService.getVipList();
        return ResponseUtil.success(userEntityList);
    }
}
