package com.sintialab.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.sintialab"})
@EnableJpaRepositories(basePackages = {"com.sintialab.repo"})
@EntityScan(basePackages = {"com.sintialab.entity"})

public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
