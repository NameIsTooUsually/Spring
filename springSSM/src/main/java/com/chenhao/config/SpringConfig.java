package com.chenhao.config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.chenhao.service","com.chenhao.dao","com.chenhao.domain"})
@PropertySource("classpath:jdbc.properties")
@Import({JdbcConfig.class,MybatisConfig.class})
@EnableTransactionManagement //开启事务管理
//@EnableAspectJAutoProxy  //开启aop
public class SpringConfig {

}
