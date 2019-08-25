package com.nalar.app.configuration;

/*
    Copyright (c) 2019 Neftali Alarcón
*/

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SecurityFilter {

    @Bean
    public FilterRegistrationBean jwtSecurityFilter() {
        final FilterRegistrationBean filter = new FilterRegistrationBean();
        filter.setFilter(new JwtFilterConf());
        filter.addUrlPatterns("/api/*");
        return filter;
    }

}
