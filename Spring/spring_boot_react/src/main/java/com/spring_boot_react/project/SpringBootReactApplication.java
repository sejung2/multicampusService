package com.spring_boot_react.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.spring_boot_react.project"})
public class SpringBootReactApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootReactApplication.class, args);
    }

}
