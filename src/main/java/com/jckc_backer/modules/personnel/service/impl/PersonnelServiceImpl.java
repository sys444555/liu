package com.jckc_backer.modules.personnel.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.modules.personnel.entity.PersonnelEntity;
import com.jckc_backer.modules.personnel.mapper.PersonnelMapper;
import com.jckc_backer.modules.personnel.service.PersonnelService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：lyj
 * @date ：Created in 2019/9/3
 * @description：
 * @modified By：
 * @version:
 */
@Service
public class PersonnelServiceImpl extends ServiceImpl<PersonnelMapper, PersonnelEntity> implements PersonnelService {

    @Resource
    private PersonnelMapper shoopMapper;

    @Override
    public void insertShoop(PersonnelEntity shoopEntity) {
        shoopMapper.insert(shoopEntity);
    }

    @Override
    public PersonnelEntity selectByName(String name) {
        PersonnelEntity shoopEntity= shoopMapper.selectByName(name);
       return shoopEntity;
    }

    @Override
    public void updateShoop(PersonnelEntity shoopEntity) {
        shoopMapper.updateById(shoopEntity);
    }

    @Override
    public void deleteById(Integer id) {
        shoopMapper.deleteById(id);
    }

    @Override
    public List<PersonnelEntity> getList(EntityWrapper<PersonnelEntity> wrapper) {
        List<PersonnelEntity> entityList=shoopMapper.selectList(wrapper);
        return entityList;
    }

}
