package com.chenhao.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author ChenHao
 * @version 1.0
 * @description: Spring核心容器初始化配置类
 * @date 2022/6/3 11:15
 */
public class SpringCoreContainer extends AbstractAnnotationConfigDispatcherServletInitializer {
    /**
     * 创建Spring容器
     *
     * @return
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /**
     * 创建SpringMVC容器
     *
     * @return
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SpringMvcConfig.class};
    }

    /**
     * 拦截请求，所有请求，包含静态资源
     *
     * @return
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * 设置全局编码过滤器，解决POST请求乱码问题
     */
    @Override
    protected Filter[] getServletFilters() {
        // 创建编码过滤器
        CharacterEncodingFilter cef = new CharacterEncodingFilter();

        // 设置编码为utf-8
        cef.setEncoding("utf-8");
        return new Filter[]{cef};
    }
}
