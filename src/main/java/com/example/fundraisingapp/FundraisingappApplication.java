package com.example.fundraisingapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"com.example.fundraisingapp.repository"})
@SpringBootApplication
public class FundraisingappApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(FundraisingappApplication.class, args);
    }
    
}