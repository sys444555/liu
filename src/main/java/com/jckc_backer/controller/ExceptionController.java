package com.jckc_backer.controller;

import com.jckc_backer.common.exception.JcException;
import com.jckc_backer.common.utils.ResponseUtil;
import com.jckc_backer.model.ResultMap;
import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description 异常处理
 */
@RestControllerAdvice
public class ExceptionController {
    private final ResultMap resultMap;

    @Autowired
    public ExceptionController(ResultMap resultMap) {
        this.resultMap = resultMap;
    }

    // 捕捉shiro的异常
    @ExceptionHandler(ShiroException.class)
    public ResultMap handle401() {
        return resultMap.fail().code(401).message("您没有权限访问！");
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResultMap handleAuthenticationException(){
        System.out.println("hello");
        return resultMap.fail().code(403).message("认证过期,请重新登录");

    }

    private static final Logger logger = LoggerFactory.getLogger(ExceptionController.class);


    /**
        * 处理自定义异常
         * @param
         * @return
    */

    @ExceptionHandler(JcException.class)
    public ResponseUtil handleJcException(JcException e){
        logger.error(e.getMsg(),e);
        return ResponseUtil.error(e.getCode(), "访问出现异常");
    }

    //处理其他异常类

    /**
         * 处理RuntimeException
        * @param
        * @return
     */

    @ExceptionHandler(RuntimeException.class)
    public ResponseUtil handleRuntimeException(Exception e){
        logger.error(e.getMessage(),e);
        return ResponseUtil.error(500, "访问出现异常");
    }


    /**
        * 处理未知异常
        * @param
        * @return
    */


    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    public ResultMap globalException(HttpServletRequest request, Throwable ex) {
        return resultMap.fail()
                .code(getStatus(request).value())
                .message("访问出错，无法访问: " + ex.getMessage());
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
