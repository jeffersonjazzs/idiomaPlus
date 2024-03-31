package com.jeff.puc.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.jeff.puc.services.impl.DBService;

//@Configuration
//@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

//    @Bean
    public boolean instantiateDatabase() {
        dbService.instantiateTestDatabase();
        return true;
    }

}
