package com.kushneruk.vitaliy.serverfamilydo.config.databaseConfig;

import com.kushneruk.vitaliy.serverfamilydo.infrastructure.property.Profiles;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

@TestConfiguration
public class DatabaseTestConfig {
    @Bean
    @ConfigurationProperties(prefix="app.datasource")
    @Profile(Profiles.TEST)
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }
}
