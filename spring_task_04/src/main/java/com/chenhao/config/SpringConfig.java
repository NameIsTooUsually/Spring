package com.chenhao.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("com.chenhao")
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
//TODO:开启Spring注解式事务驱动
@EnableTransactionManagement
//开启AOP通知管理
@EnableAspectJAutoProxy
public class SpringConfig {
}
