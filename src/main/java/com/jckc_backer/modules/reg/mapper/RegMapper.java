package com.jckc_backer.modules.reg.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jckc_backer.entity.RoleUserEntity;

public interface RegMapper extends BaseMapper<RoleUserEntity> {


    RoleUserEntity findByUname(String uname);
}
