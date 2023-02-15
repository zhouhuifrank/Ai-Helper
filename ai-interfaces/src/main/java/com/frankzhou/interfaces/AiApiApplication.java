package com.frankzhou.interfaces;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AiApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(AiApiApplication.class, args);
        System.out.println("=================================");
        System.out.println("=========AI问答助手启动成功=========");
        System.out.println("=================================");
    }

}
