package com.ssafy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ssafy.happyhouse.interceptor.JwtInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	
    private static final String[] EXCLUDE_PATHS = {
            "/user/*"
    };

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
    	/*
        registry.addInterceptor(JwtInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns(EXCLUDE_PATHS);
        */
    }
}