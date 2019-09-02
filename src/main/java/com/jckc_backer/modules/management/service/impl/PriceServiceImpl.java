package com.jckc_backer.modules.management.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.management.entity.PriceEntity;
import com.jckc_backer.modules.management.mapper.PriceMapper;
import com.jckc_backer.modules.management.service.PriceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PriceServiceImpl extends ServiceImpl<PriceMapper, PriceEntity> implements PriceService {

    @Resource
    private PriceMapper priceMapper;

    @Override
    public void insertPrice(PriceEntity priceEntity) {
        priceMapper.insert(priceEntity);
    }

    @Override
    public void updatePrice(PriceEntity priceEntity) {
        priceMapper.updateById(priceEntity);
    }

    @Override
    public void deleteById(Integer id) {
        priceMapper.deleteById(id);
    }

    @Override
    public List<PriceEntity> getList(EntityWrapper<PriceEntity> wrapper) {
        List<PriceEntity> entityList=priceMapper.selectList(wrapper);
        return entityList;
    }

}
