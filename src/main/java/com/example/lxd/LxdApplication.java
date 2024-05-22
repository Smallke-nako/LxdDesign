package com.example.lxd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.lxd.mapper")
//@EnableScheduling
public class LxdApplication {

    public static void main(String[] args) {
        SpringApplication.run(LxdApplication.class, args);
    }

}
