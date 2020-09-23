package com.jckc_backer.modules.management.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.modules.management.entity.PictureEntity;

import java.util.List;


/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:55
 * @description：
 * @modified By：
 * @version:
 */
public interface PictureService extends IService<PictureEntity>{

    void insertPicture(PictureEntity pictureEntity);


    void updatePicture(PictureEntity pictureEntity);


    List<PictureEntity> getListBytype(String type);

  List<PictureEntity> getList(EntityWrapper<PictureEntity> wrapper);

    void updownById(Integer id);
}
