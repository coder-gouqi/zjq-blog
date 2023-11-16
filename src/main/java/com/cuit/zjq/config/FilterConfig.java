package com.cuit.zjq.config;

import com.cuit.zjq.filter.MyFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean registrationBean() {
        FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new MyFilter());
        filter.addUrlPatterns("/*");
        return filter;
    }
}