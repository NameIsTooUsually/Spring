package com.chenhao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author ChenHao
 * @version 1.0
 * @description: SpringMVC配置类
 * @date 2022/6/3 10:58
 */

@Configuration
@ComponentScan("com.chenhao.web") // 只扫web层
@EnableWebMvc                     // jackson自动反序列化&类型转换等
public class SpringMvcConfig extends WebMvcConfigurationSupport {

    //设置对静态资源进行放行
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //设置需要放行的静态资源，设置放行后访问的路径
        registry.addResourceHandler("pages/**").addResourceLocations("/pages/");
    }
}
