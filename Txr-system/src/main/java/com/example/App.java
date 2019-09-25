package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import com.example.config.TxrSystemConfiguration;

public class App extends SpringBootServletInitializer{

	public static void main(String[] args) {
		
		// ------------------------------------------
		// Init/boot
		// ------------------------------------------
		SpringApplication.run(TxrSystemConfiguration.class, args);
		
		
	}

}
