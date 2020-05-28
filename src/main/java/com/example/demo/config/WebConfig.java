package com.example.demo.config;

import com.example.demo.filter.CustomFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

@Configuration
public class WebConfig {

    @Resource
    private CustomFilter customFilter;

    @Bean
    public FilterRegistrationBean<CustomFilter> initFilterRegistrationBean(){
        FilterRegistrationBean<CustomFilter> registrationBean=new FilterRegistrationBean<>();
        registrationBean.setFilter(customFilter);
        registrationBean.setOrder(-100);

        return registrationBean;
    }
}
