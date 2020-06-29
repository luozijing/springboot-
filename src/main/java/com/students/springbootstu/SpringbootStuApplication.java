package com.students.springbootstu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.students.springbootstu.dao")

public class SpringbootStuApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootStuApplication.class, args);
    }

}
