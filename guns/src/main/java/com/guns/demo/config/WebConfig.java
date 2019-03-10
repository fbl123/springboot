package com.guns.demo.config;

import com.guns.demo.Interceptor.MyInterceptor;
import com.guns.demo.converter.StuConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

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
//    @Bean
//    public WebMvcConfigurer webMvcConfigurer() {
//        // 添加拦截器
//        WebMvcConfigurer webMvcConfigurer = new WebMvcConfigurer() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//
//                registry.addInterceptor(new MyInterceptor()).addPathPatterns("/user/**");
//            }
//        };
//        return webMvcConfigurer;
//    }


    /**
     * 添加自定义类型转换器
     * @return
     */
//    @Bean
//    public ConversionService conversionService(){
//        ConversionServiceFactoryBean conversionServiceFactoryBean=new ConversionServiceFactoryBean();
//
//        Set<Converter> set=new HashSet<>();
//        set.add(new StuConverter());
//        conversionServiceFactoryBean.setConverters(set);
//        conversionServiceFactoryBean.afterPropertiesSet();
//        return conversionServiceFactoryBean.getObject();
//
//    }



}
