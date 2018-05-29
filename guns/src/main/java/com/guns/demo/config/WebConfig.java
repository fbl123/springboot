package com.guns.demo.config;

import com.guns.demo.Interceptor.MyInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig {


    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter webMvcConfigurerAdapter=new WebMvcConfigurerAdapter(){
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
            }
        };
        return webMvcConfigurerAdapter;
    }
}
