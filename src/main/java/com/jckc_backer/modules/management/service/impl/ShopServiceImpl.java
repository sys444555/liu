package com.jckc_backer.modules.management.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.management.entity.ShopEntity;
import com.jckc_backer.modules.management.mapper.ShopMapper;
import com.jckc_backer.modules.management.service.ShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, ShopEntity> implements ShopService {

    @Resource
    private ShopMapper shopMapper;

    @Override
    public void insertPrice(ShopEntity shopEntity) {
        shopMapper.insert(shopEntity);
    }

    @Override
    public void updatePrice(ShopEntity shopEntity) {
        shopMapper.updateById(shopEntity);
    }

    @Override
    public void deleteById(Integer id) {
        shopMapper.deleteById(id);
    }

    @Override
    public List<ShopEntity> getList(EntityWrapper<ShopEntity> wrapper) {
        List<ShopEntity> entityList=shopMapper.selectList(wrapper);
        return entityList;
    }

}
