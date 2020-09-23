package com.jckc_backer.modules.reg.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.jckc_backer.entity.RoleUserEntity;
import com.jckc_backer.modules.exc.UsernameDuplicateException;
import com.jckc_backer.modules.reg.mapper.RegMapper;
import com.jckc_backer.modules.reg.service.RegService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegServiceImpl extends ServiceImpl<RegMapper, RoleUserEntity> implements RegService {

    @Resource
    private RegMapper regMapper;

    @Override
    public void reg(RoleUserEntity regEntity) throws UsernameDuplicateException {
        String uname=regEntity.getUsername();
        System.out.println(regEntity);
        RoleUserEntity regEntities=regMapper.findByUname(uname);
        if(regEntities==null){
            regMapper.insert(regEntity);
        }else{
            throw new UsernameDuplicateException("注册失败！您尝试注册的用户名( "+ uname + ")已经被占用！");
        }
    }

}
