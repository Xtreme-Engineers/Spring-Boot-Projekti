package com.example.ohjelmointiprojekti1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ohjelmointiprojekti1Application {
	private static final Logger log = LoggerFactory.getLogger(Ohjelmointiprojekti1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Ohjelmointiprojekti1Application.class, args);
	}

}
