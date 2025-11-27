package com.GinElmaC;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.GinElmaC"})
public class KeepAliveMidRunApplication {
    public static void main(String[] args) {
        SpringApplication.run(KeepAliveMidRunApplication.class, args);
    }
}
