package com.spring.mybatis.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.spring.mybatis.project")
public class SpringBootMybatisExApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMybatisExApplication.class, args);
    }

}
