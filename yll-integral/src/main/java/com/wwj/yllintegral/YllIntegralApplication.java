package com.wwj.yllintegral;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wwj.yllintegral.mapper")
public class YllIntegralApplication {

    public static void main(String[] args) {
        SpringApplication.run(YllIntegralApplication.class, args);
    }

}
