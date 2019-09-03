package com.jckc_backer.modules.user.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.user.entity.CustomerEntity;
import com.jckc_backer.modules.user.mapper.CustomerMapper;
import com.jckc_backer.modules.user.service.CustomerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: Charles Chan
 * @Date: 2019/9/3 16:21
 * @Version 1.0
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, CustomerEntity> implements CustomerService {

    @Resource
    private CustomerMapper customerMapper;

    @Override
    public List<CustomerEntity> getVipList() {
        List<CustomerEntity> vipList = customerMapper.selectList(new EntityWrapper<CustomerEntity>().eq("vip", 1));
        return vipList;
    }
}
