package com.jckc_backer.modules.management.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.management.entity.PriceEntity;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:55
 * @description：
 * @modified By：
 * @version:
 */
public interface PriceService extends IService<PriceEntity>{

    void insertPrice(PriceEntity pictureEntity);


    void updatePrice(PriceEntity pictureEntity);

    void deleteById(Integer id);

    List<PriceEntity> getList(EntityWrapper<PriceEntity> wrapper);

}
