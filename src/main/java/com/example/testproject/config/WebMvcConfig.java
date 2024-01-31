package com.example.testproject.config;

import com.example.testproject.interceptor.HttpInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new HttpInterceptor()) // 인터셉터 추가
            .addPathPatterns("/**") // 어떤 경로에서 수행
            .excludePathPatterns("/hello"); // 예외처리
    }
}
