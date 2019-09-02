package com.jckc_backer;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan({"com.jckc_backer.**.mapper","com.jckc_backer.mapper"})
@SpringBootConfiguration
@EnableTransactionManagement
@EnableScheduling
/*@ComponentScan(basePackages={"com.jckc_backer.config"})*/
public class JckcBackerApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(JckcBackerApplication.class);
    }


    public static void main(String[] args) {
        SpringApplication.run(JckcBackerApplication.class, args);
    }
}
