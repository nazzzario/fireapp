package com.store;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootApplication
public class FireApplication {
    public static void main(String[] args) {
        SpringApplication.run(FireApplication.class, args);
    }
}
