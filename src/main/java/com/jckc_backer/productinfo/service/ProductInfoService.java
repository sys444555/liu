package com.jckc_backer.productinfo.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.productinfo.entity.ProductInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 *
 * @author fenghuang
 * @email 
 * @date 2019-08-30 16:40:17
 */
public interface ProductInfoService extends IService<ProductInfoEntity> {

    public List<ProductInfoEntity> productInfoList(EntityWrapper<ProductInfoEntity> entityEntityWrapper);
}

