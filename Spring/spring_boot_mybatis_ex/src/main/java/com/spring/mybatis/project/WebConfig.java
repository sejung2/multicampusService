package com.spring.mybatis.project;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/product_images/**")
                .addResourceLocations("file:C:/product_images/");
        registry.addResourceHandler("/images/**")
                .addResourceLocations("file:C:/Users/USER/myWork/multicampus/upload/");
    }
}