package com.chenhao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@PropertySource("jdbc.properties")
@ComponentScan("com.chenhao")
@Import({MybatisConfig.class,JdbcConfig.class})
//开启事务管理
@EnableTransactionManagement
public class SpringConfig {

}
