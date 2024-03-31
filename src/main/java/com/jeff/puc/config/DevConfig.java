package com.jeff.puc.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.jeff.puc.services.impl.DBService;

//@Configuration
//@Profile("dev")
public class DevConfig {

	private DBService dbService;

	public DevConfig(DBService dbService) {
		this.dbService = dbService;
	}

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String strategy;

	// @Bean
	public boolean instantiateDatabase() throws ParseException {

		if (!"create".equals(strategy)) {
			return false;
		}

		dbService.instantiateTestDatabase();
		return true;
	}

}