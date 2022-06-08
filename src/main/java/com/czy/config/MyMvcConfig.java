package com.czy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 声明这是一个自定义的webmvc控制类
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index.html");
        registry.addViewController("/index").setViewName("index.html");
        registry.addViewController("/dashboard").setViewName("dashboard.html");
        registry.addViewController("/emplist").setViewName("emp/list.html");
    }
    /*
    使用@Bean注解将这个组件注册到Spring容器中，注意你需要注册的组件的方法一定是该类名的首字母小写
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocalResolver();
    }
    /*
    注册拦截器,设置需要拦截的以及需要放行的
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/"
                        , "/index"
                        ,"/login"
                        ,"/css/**"
                        ,"/img/**"
                        ,"/js/**");
    }
}
