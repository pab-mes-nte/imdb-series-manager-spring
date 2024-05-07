package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("com.example.model.entities")
@EnableJpaRepositories(basePackages = "com.example.model.repositories")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}