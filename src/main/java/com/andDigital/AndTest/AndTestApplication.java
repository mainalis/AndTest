package com.andDigital.AndTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AndTestApplication {

	public static void main(String[] args) {
		Util.init();
		SpringApplication.run(AndTestApplication.class, args);
	}

}
