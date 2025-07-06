package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.controller","com.model","com.service","com.validate"})
public class PreschoolApplication {

	public static void main(String[] args) {
		SpringApplication.run(PreschoolApplication.class, args);
	}

}