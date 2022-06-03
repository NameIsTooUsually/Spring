package com.chenhao.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @author ChenHao
 * @version 1.0
 * @description: JDBC配置类，配置DataSource
 * @date 2022/6/3 10:27
 */
//引入配置文件
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String userName;
    @Value("${jdbc.password}")
    private String password;

    /**
     * 装配Bean：DruidDataSource
     * @return
     */
    @Bean
    public DataSource dataSource(){
        //创建druid数据源
        DruidDataSource ds = new DruidDataSource();
        //设置连接四要素
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUsername(userName);
        ds.setPassword(password);
        return ds;
    }
}
