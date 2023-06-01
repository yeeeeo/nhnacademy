package com.nhnacademy.residentmanage.config;

import com.nhnacademy.residentmanage.Base;
import lombok.RequiredArgsConstructor;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackageClasses = Base.class,
    excludeFilters = @ComponentScan.Filter(Controller.class))
@RequiredArgsConstructor
public class RootConfig {
    private final DatabaseProperties properties;

    @Bean
    public DataSource dataSource() {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(properties.getDriverClassName());
        dataSource.setUrl(properties.getUrl());
        dataSource.setUsername(properties.getUsername());
        dataSource.setPassword(properties.getPassword());
        dataSource.setInitialSize(properties.getInitialSize());
        dataSource.setMaxTotal(properties.getMaxTotal());
        dataSource.setMinIdle(properties.getMinIdle());
        dataSource.setMaxIdle(properties.getMaxIdle());
        dataSource.setMaxWaitMillis(properties.getMaxWaitMillis());
        dataSource.setTestOnBorrow(properties.isTestOnBorrow());
        dataSource.setTestOnReturn(properties.isTestOnReturn());
        dataSource.setTestWhileIdle(properties.isTestWhileIdle());
        if (properties.isTestOnBorrow() &&
                properties.isTestOnReturn() &&
                properties.isTestWhileIdle()){
            dataSource.setValidationQuery(dataSource.getValidationQuery());
        }
        return dataSource;
    }

}
