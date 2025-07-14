package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.crs.controller, com.crs.service, com.crs.repository")
@EntityScan("com.crs.entity")
@EnableJpaRepositories("com.crs.repository")
public class CollegeRegistrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(CollegeRegistrationApplication.class, args);
	}

}


