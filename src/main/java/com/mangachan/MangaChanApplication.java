package com.mangachan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.mangachan")
public class MangaChanApplication {

    public static void main(String[] args) {
        SpringApplication.run(MangaChanApplication.class, args);
    }

}
