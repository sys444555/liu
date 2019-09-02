package com.jckc_backer.controller;

import com.jckc_backer.entity.RoleUserEntity;
import com.jckc_backer.mapper.RoleUserMapper;
import com.jckc_backer.model.ResultMap;
import com.jckc_backer.modules.reg.service.RegService;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 *
 * @Author
 * @Description user角色权限controller
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private RoleUserMapper userMapper;

    @Resource
    private ResultMap resultMap;

    @Resource
    private RegService regService;

    /**
     * 拥有 user, admin 角色的用户可以访问下面的页面
     */
    @GetMapping("/getMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap getMessage() {

        return resultMap.success().code(200).message("成功获得信息！");
    }

    @PostMapping("/updatePassword")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    public ResultMap updatePassword(String username, String oldPassword, String newPassword) {
        String dataBasePassword = userMapper.getPassword(username);
        if (dataBasePassword.equals(oldPassword)) {
            userMapper.updatePassword(username, newPassword);
        } else {
            return resultMap.fail().message("密码错误！");
        }
        return resultMap.success().code(200).message("成功获得信息！");
    }

    /**
     * 拥有 vip 权限可以访问该页面
     */
    @GetMapping("/getVipMessage")
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResultMap getVipMessage() {

        return resultMap.success().code(200).message("成功获得 vip 信息！");
    }

    @RequestMapping(value="/reg",method= RequestMethod.POST)
    @RequiresRoles(logical = Logical.OR, value = {"user", "admin"})
    @RequiresPermissions("vip")
    public ResultMap getVipReg(RoleUserEntity regEntity) {

        System.out.println(regEntity);
        regService.reg(regEntity);
        return resultMap.success().code(200).message("注册成功");
    }
}
