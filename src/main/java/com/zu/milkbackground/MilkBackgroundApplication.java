package com.zu.milkbackground;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zu.milkbackground.mapper")
public class MilkBackgroundApplication {
    public static void main(String[] args) {
        SpringApplication.run(MilkBackgroundApplication.class, args);
    }
}
