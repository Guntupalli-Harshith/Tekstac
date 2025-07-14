package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.bean")
@ComponentScan(basePackages={"com.repository","com.controller","com.bean","com.dao"})
@EnableJpaRepositories("com.repository")
@SpringBootApplication
public class SchoolStrengthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchoolStrengthApplication.class, args);
    }
}