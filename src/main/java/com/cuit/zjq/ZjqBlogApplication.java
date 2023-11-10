package com.cuit.zjq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class ZjqBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZjqBlogApplication.class, args);
    }

}
