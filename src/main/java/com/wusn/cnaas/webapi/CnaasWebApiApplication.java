package com.wusn.cnaas.webapi;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@EnableDubbo
@SpringBootApplication
public class CnaasWebApiApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(CnaasWebApiApplication.class, args);
    }

    // 按照下面的方式重写
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(CnaasWebApiApplication.class);
    }

}
