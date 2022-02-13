package com.example.demo.dao.datasource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MYSQLDatasource {



    @Bean
    @ConfigurationProperties("app.datasource")
    public HikariDataSource hikariDataSource(){
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("com.mysql.cj.jdbc.Driver");
        config.setJdbcUrl("jdbc:hsqldb:hsql://rds-mysql-onlineshop.cfmau8cbluqk.us-east-1.rds.amazonaws.com");
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }
}
