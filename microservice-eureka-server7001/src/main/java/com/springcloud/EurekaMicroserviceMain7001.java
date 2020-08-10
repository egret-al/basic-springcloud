package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 11:56
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaMicroserviceMain7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaMicroserviceMain7001.class, args);
    }
}
