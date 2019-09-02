package com.jckc_backer.productinfo.service.impl;

import com.jckc_backer.productinfo.entity.ProductInfoEntity;
import com.jckc_backer.productinfo.mapper.ProductInfoMapper;
import com.jckc_backer.productinfo.service.ProductInfoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import javax.annotation.Resource;


@Service
public class ProductInfoServiceImpl extends ServiceImpl<ProductInfoMapper, ProductInfoEntity> implements ProductInfoService {

    @Resource
    private ProductInfoMapper productInfoMapper;

    public List<ProductInfoEntity> productInfoList(EntityWrapper<ProductInfoEntity> entityEntityWrapper){

           return  productInfoMapper.selectList(entityEntityWrapper);
    }
}
