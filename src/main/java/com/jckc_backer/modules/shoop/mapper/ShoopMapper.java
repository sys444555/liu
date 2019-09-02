package com.jckc_backer.modules.shoop.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.modules.shoop.entity.ShoopEntity;

/**
 * @author ：fenghuang
 * @date ：Created in 2019/5/22 14:53
 * @description：
 * @modified By：
 * @version:
 */

public interface ShoopMapper extends BaseMapper<ShoopEntity> {

    ShoopEntity selectByName(String name);
}
