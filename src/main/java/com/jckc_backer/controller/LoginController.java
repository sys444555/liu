package com.jckc_backer.controller;

import com.jckc_backer.mapper.RoleUserMapper;
import com.jckc_backer.model.ResultMap;
import com.jckc_backer.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * @Author
 * @Description
 * @Date
 * @Time
 */
@RestController
public class LoginController {

    @Autowired
    private JWTUtil jwtUtil;

    @Resource
    private RoleUserMapper userMapper;

    @Resource
    private ResultMap resultMap;

    @PostMapping("/login")
    public ResultMap login(@RequestParam(value = "username") String username,
                           @RequestParam(value = "password") String password,
                           HttpServletRequest request) {
        request.getSession().setAttribute("uid", 1);

        String realPassword = userMapper.getPassword(username);
        if (realPassword == null) {
            return resultMap.fail().code(401).message("用户名错误");
        } else if (!realPassword.equals(password)) {
            return resultMap.fail().code(401).message("密码错误");
        } else {
            String token=jwtUtil.createToken(username);

            return resultMap.success().code(200).message(token);
        }
    }

    @RequestMapping(path = "/unauthorized/{message}")
    public ResultMap unauthorized(@PathVariable String message) throws UnsupportedEncodingException {
        return resultMap.success().code(401).message(message);
    }
}
