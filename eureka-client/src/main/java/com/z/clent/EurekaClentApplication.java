package com.z.clent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EurekaClentApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaClentApplication.class, args);
    }

}
