package com.kushneruk.vitaliy.serverfamilydo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@EnableJdbcRepositories
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class ServerFamilyDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServerFamilyDoApplication.class, args);
	}
}
