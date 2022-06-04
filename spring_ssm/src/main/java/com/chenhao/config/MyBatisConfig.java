package com.chenhao.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @author ChenHao
 * @version 1.0
 * @description: MyBatis配置类，
 * @date 2022/6/3 10:42
 */
public class MyBatisConfig {
    /**
     * 装配bean：SqlSessionFactoryBean，用于产生SqlSessionFactory对象，并最终生成SqlSession
     * 需要注入DataSource对象，Mybatis核心配置文件中大多数配置都配置在这里
     *
     */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean ssfb = new SqlSessionFactoryBean();
        // 设置别名
        ssfb.setTypeAliasesPackage("com.chenhao.domain");
        // 设置数据源
        ssfb.setDataSource(dataSource);
        return ssfb;
    }

    /**
     * 装配bean：MapperScannerConfigurer，用于扫描映射配置文件和对应的接口（上注解）
     * @return
     */
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        // 指定扫描映射配置文件/接口的路径
        msc.setBasePackage("com.chenhao.dao");
        return msc;
    }

    //配置事务管理器，mybatis使用的是jdbc事务
    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dtm = new DataSourceTransactionManager();
        dtm.setDataSource(dataSource);
        return dtm;
    }
}
