package com.jckc_backer.modules.management.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.modules.management.entity.PictureEntity;

import java.util.List;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:53
 * @description：
 * @modified By：
 * @version:
 */

public interface PictureMapper extends BaseMapper<PictureEntity> {

    List<PictureEntity> selectByType(String type);

    void updateStatus(Integer id);
}
