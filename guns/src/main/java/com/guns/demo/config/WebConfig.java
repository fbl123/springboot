package com.guns.demo.config;

import com.guns.demo.Interceptor.MyInterceptor;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.*;
import java.io.IOException;

@Configuration
public class WebConfig {


//    @Bean
//    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
//        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
//            }
//        };
//        return webMvcConfigurerAdapter;
//    }

//    /**
//     * 将POST请求转为PUT，DELETE请求
//     * @return
//     */
//    @Bean
//    public FilterRegistrationBean filterRegistrationBean() {
//        FilterRegistrationBean filterRegistrationBean=new FilterRegistrationBean();
//        filterRegistrationBean.setFilter(new HiddenHttpMethodFilter());
//        filterRegistrationBean.addUrlPatterns("/*");
//        return  filterRegistrationBean;
//    }

    /**
     * @return
     */
    @Bean
    public WebMvcConfigurer webMvcConfigurer() {
        // 添加拦截器
        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
            }
        };
        return webMvcConfigurer;
    }


}
