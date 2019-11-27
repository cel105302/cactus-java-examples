package com.cactus.demo.cactusspringboot.unsubmit.config;

import com.cactus.demo.cactusspringboot.unsubmit.interceptor.SpecialIntercept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SpecialConfiguration {

    @Bean
    public SpecialIntercept specialIntercept(){
        return new SpecialIntercept();
    }

    @Configuration
    class RegisterInterceptor implements WebMvcConfigurer{

        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(specialIntercept()).addPathPatterns("/**");
        }
    }
}
