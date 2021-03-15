package com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author guoga
 * @version 11:45 2020/5/12
 */
@SpringBootApplication
@MapperScan("com.iSpringboot.dao")
public class StartAppliction {

    public static void main(String[] args) {
        SpringApplication.run(StartAppliction.class, args);
    }

    @Bean
    public PropertySourcesPlaceholderConfigurer initProperties() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
