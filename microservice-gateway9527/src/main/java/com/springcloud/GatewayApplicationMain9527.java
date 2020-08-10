package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Mono;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/8 11:55
 */
@EnableEurekaClient
@SpringBootApplication
public class GatewayApplicationMain9527 {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicationMain9527.class, args);
    }
}
