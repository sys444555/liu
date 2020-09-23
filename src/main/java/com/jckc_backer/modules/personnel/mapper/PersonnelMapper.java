package com.jckc_backer.modules.personnel.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.modules.personnel.entity.PersonnelEntity;

/**
 * @author ：lyj
 * @date ：Created in 2019/9/3
 * @description：
 * @modified By：
 * @version:
 */

public interface PersonnelMapper extends BaseMapper<PersonnelEntity> {

    PersonnelEntity selectByName(String name);
}
