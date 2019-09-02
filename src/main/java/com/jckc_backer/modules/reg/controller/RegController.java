package com.jckc_backer.modules.reg.controller;

import com.jckc_backer.entity.RoleUserEntity;
import com.jckc_backer.modules.reg.service.RegService;
import com.jckc_backer.modules.utils.ResponseResult;
import com.jckc_backer.shiro.CustomRealm;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.realm.AuthorizingRealm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import static jdk.nashorn.tools.Shell.SUCCESS;


@RestController
@RequestMapping("/reg")
public class RegController {

    @Resource
    private RegService regService;

    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResponseResult<Void> handleReg(RoleUserEntity regEntity) {
        System.out.println(regEntity);
        regService.reg(regEntity);
        return new ResponseResult<Void>(SUCCESS);
    }

}
