package com.jckc_backer.modules.personnel.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.personnel.entity.PersonnelEntity;
import java.util.List;

/**
 * @author ：lyj
        * @date ：Created in 2019/9/3
        * @description：
        * @modified By：
        * @version:
        */
public interface PersonnelService extends IService<PersonnelEntity>{

    void insertShoop(PersonnelEntity shoopEntity);

    PersonnelEntity selectByName(String name);

    void updateShoop(PersonnelEntity shoopEntity);

    void deleteById(Integer id);

    List<PersonnelEntity> getList(EntityWrapper<PersonnelEntity> wrapper);
}
