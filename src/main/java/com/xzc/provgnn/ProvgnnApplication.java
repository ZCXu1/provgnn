package com.xzc.provgnn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.xzc.provgnn.mapper")
@SpringBootApplication
public class ProvgnnApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProvgnnApplication.class, args);
    }

}
