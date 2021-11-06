package com.activiti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {
    org.activiti.spring.boot.SecurityAutoConfiguration.class})
public class SpringBootActivitiApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootActivitiApplication.class, args);
    }

}
