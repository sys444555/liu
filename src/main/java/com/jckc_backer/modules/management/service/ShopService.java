package com.jckc_backer.modules.management.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.management.entity.ShopEntity;

import java.util.List;


public interface ShopService extends IService<ShopEntity>{

    void insertPrice(ShopEntity shopEntity);

    void updatePrice(ShopEntity shopEntity);

    void deleteById(Integer id);

    List<ShopEntity> getList(EntityWrapper<ShopEntity> wrapper);

}
