package com.jckc_backer.modules.shoop.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.shoop.entity.ShoopEntity;
import com.jckc_backer.modules.shoop.mapper.ShoopMapper;
import com.jckc_backer.modules.shoop.service.ShoopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class ShoopServiceImpl extends ServiceImpl<ShoopMapper, ShoopEntity> implements ShoopService {

    @Resource
    private ShoopMapper shoopMapper;

    @Override
    public void insertShoop(ShoopEntity shoopEntity) {
        if(shoopEntity.getStatus()==null){
            shoopEntity.setStatus("未成交");
        }
        if(shoopEntity.getNumber()==null){
            shoopEntity.setNumber("111111");
        }
        shoopMapper.insert(shoopEntity);
    }

    @Override
    public ShoopEntity selectByName(String name) {
       ShoopEntity shoopEntity= shoopMapper.selectByName(name);
       return shoopEntity;
    }

    @Override
    public void updateShoop(ShoopEntity shoopEntity) {
        shoopMapper.updateById(shoopEntity);
    }

    @Override
    public void deleteById(Integer id) {
        shoopMapper.deleteById(id);
    }

    @Override
    public List<ShoopEntity> getList(EntityWrapper<ShoopEntity> wrapper) {
        List<ShoopEntity> entityList=shoopMapper.selectList(wrapper);
        return entityList;
    }

}
