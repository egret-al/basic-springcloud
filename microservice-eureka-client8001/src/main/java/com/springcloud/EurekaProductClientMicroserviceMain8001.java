package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 12:20
 */
@EnableEurekaClient
@SpringBootApplication
public class EurekaProductClientMicroserviceMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProductClientMicroserviceMain8001.class, args);
    }
}
