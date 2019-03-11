package com.guns.demo.config;

//import com.guns.demo.common.User;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {"classpath:sys.properties"})
//@EnableConfigurationProperties(value = User.class)
public class LoadProperties {
}
