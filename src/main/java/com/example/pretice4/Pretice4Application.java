package com.example.pretice4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Pretice4Application {

    public static void main(String[] args) {
        SpringApplication.run(Pretice4Application.class, args);
    }

}
