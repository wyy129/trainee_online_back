package com.example.trainee_online_back;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@MapperScan("com.example.trainee_online_back.mapper")
public class TraineeOnlineBackApplication {

    public static void main(String[] args) {
        SpringApplication.run(TraineeOnlineBackApplication.class, args);
    }

}
