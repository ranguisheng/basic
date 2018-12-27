package com.guishengran.config;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @Auther: guish
 * @Date: 2018/12/27 09:48
 * @Description:
 */
@Configuration
@EnableTransactionManagement
public class DruidConfig {
    @Bean("report")
    @Qualifier("report")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSourceReport(){
        return DruidDataSourceBuilder.create().build();
    }
}
