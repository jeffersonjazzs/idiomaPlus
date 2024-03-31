package com.jeff.puc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IdiomaPlusApplication implements CommandLineRunner {
	 
	public static void main(String[] args) {
		SpringApplication.run(IdiomaPlusApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciado...");
		
		
	}
}
