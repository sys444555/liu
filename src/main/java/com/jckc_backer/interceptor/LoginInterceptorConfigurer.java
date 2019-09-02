package com.jckc_backer.interceptor;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class LoginInterceptorConfigurer
        implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截路径：必须登录才可以访问
        List<String> patterns = new ArrayList<>();
        patterns.add("/**");

        // 白名单：在黑名单范围内，却不需要登录就可以访问
        List<String> excludePatterns = new ArrayList<>();
        excludePatterns.add("/static/bootstrap3/**");
        excludePatterns.add("/css/**");
        excludePatterns.add("/js/**");
        excludePatterns.add("/images/**");
        excludePatterns.add("/fonts/**");
        excludePatterns.add("/img/**");
        excludePatterns.add("/plugins/fullavatareditor/scripts/**");
        excludePatterns.add("/shoop/insert");
        excludePatterns.add("/shoop/select");
        excludePatterns.add("/shoopdelete/{id}");
        excludePatterns.add("/shoop/update");
        excludePatterns.add("/reg/insert");
        excludePatterns.add("/login");
        excludePatterns.add("/page/login");
        excludePatterns.add("/usr/local/ngnix/html/pic/img/shopImg/**");
        excludePatterns.add("/shop/list");
        excludePatterns.add("/price/list");

        excludePatterns.add("/picture/list");

      //   注册拦截器
        registry
                .addInterceptor(new LoginInterceptor())
                .addPathPatterns(patterns)
                .excludePathPatterns(excludePatterns);
    }

}
