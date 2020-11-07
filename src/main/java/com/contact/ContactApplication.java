package com.contact;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class ContactApplication {
    public static void main(String[] args) {
        SpringApplication.run(ContactApplication.class);
    }
}
