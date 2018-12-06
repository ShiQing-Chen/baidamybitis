package com.chen.baida.config;

import com.chen.baida.interceptor.SecurityHandlerInterceptor;
import com.chen.baida.session.SharedUserArgumentResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author ShiQing_Chen 2018-12-06
 * @since 0.0.1
 */
@Configuration
public class DispatcherConfig extends WebMvcConfigurerAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger(DispatcherConfig.class);

    @Bean
    public SecurityHandlerInterceptor securityHandlerInterceptor(){
        return new SecurityHandlerInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LOGGER.info("######## 配置拦截器... ########");
        SecurityHandlerInterceptor interceptor = securityHandlerInterceptor();
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(interceptor).addPathPatterns("/**");

        for(String exUrl:SecurityHandlerInterceptor.URL_EXCLUDE_LIST){
            interceptorRegistration.excludePathPatterns(exUrl);
        }

    }

    @Bean
    public SharedUserArgumentResolver sharedUserArgumentResolver() {
        return new SharedUserArgumentResolver();
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(sharedUserArgumentResolver());
    }
}