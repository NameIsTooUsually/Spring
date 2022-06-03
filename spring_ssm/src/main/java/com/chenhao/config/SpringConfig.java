package com.chenhao.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ChenHao
 * @version 1.0
 * @description: Spring配置类
 * @date 2022/6/3 11:04
 */

@Configuration
@ComponentScan({"com.chenhao.service"}) //组件扫描，扫非web层
@Import({JdbcConfig.class,MyBatisConfig.class}) //引入分配置类，有条件省略
@EnableTransactionManagement // 启用事务管理器
public class SpringConfig {
}