package com.nhnacademy.residentmanage.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = "classpath:db.properties")
@Getter
@Setter
public class DatabaseProperties {
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Value("${db.driverClassName}")
    private String driverClassName;
    @Value("${db.url}")
    private String url;
    @Value("${db.initialSize}")
    private int initialSize;
    @Value("${db.maxTotal}")
    private int maxTotal;
    @Value("${db.maxIdle}")
    private int maxIdle;
    @Value("${db.minIdle}")
    private int minIdle;
    @Value("${db.maxWaitMillis}")
    private int maxWaitMillis;
    @Value("${db.validationQuery}")
    private String validationQuery;
    @Value("${db.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${db.testOnReturn}")
    private boolean testOnReturn;
    @Value("${db.testWhileIdle}")
    private boolean testWhileIdle;

    public boolean isTestOnBorrow() {
        return testOnBorrow;
    }
    public boolean isTestOnReturn() {
        return testOnReturn;
    }
    public boolean isTestWhileIdle() {
        return testWhileIdle;
    }
}
