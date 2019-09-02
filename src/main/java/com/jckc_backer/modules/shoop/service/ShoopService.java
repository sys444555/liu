package com.jckc_backer.modules.shoop.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.shoop.entity.ShoopEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:55
 * @description：
 * @modified By：
 * @version:
 */
public interface ShoopService extends IService<ShoopEntity>{

    void insertShoop(ShoopEntity shoopEntity);

    ShoopEntity selectByName(String name);

    void updateShoop(ShoopEntity shoopEntity);

    void deleteById(Integer id);

    List<ShoopEntity> getList(EntityWrapper<ShoopEntity> wrapper);
}
