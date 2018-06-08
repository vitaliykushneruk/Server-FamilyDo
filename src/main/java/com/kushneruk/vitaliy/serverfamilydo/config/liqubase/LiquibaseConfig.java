package com.kushneruk.vitaliy.serverfamilydo.config.liqubase;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class LiquibaseConfig {
    @Autowired
    DataSource dataSource;

    @Bean
    @ConfigurationProperties(prefix = "spring.liquibase")
    LiquibaseProperties liquibaseProperties(){

        return new LiquibaseProperties();
    }

    @Bean
    SpringLiquibase liquibase() {

        SpringLiquibase liquibase = new SpringLiquibase();
        liquibase.setChangeLog(liquibaseProperties().getChangeLog());
        liquibase.setDefaultSchema(liquibaseProperties().getDefaultSchema());
        liquibase.setDataSource(dataSource);
        return liquibase;
    }
}
