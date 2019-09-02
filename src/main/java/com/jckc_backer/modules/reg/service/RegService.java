package com.jckc_backer.modules.reg.service;

import com.baomidou.mybatisplus.service.IService;
import com.jckc_backer.entity.RoleUserEntity;
import com.jckc_backer.modules.exc.UsernameDuplicateException;

public interface RegService extends IService<RoleUserEntity> {

    void reg(RoleUserEntity regEntity)throws UsernameDuplicateException;

}
