package com.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/10 9:05
 */
@EnableConfigServer
@SpringBootApplication
public class ConfigServerMain7100 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerMain7100.class, args);
    }
}
