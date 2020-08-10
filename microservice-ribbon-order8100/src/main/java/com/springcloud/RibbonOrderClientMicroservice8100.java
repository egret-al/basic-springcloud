package com.springcloud;

import com.config.CustomisationLoadBalanceStrategy;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @SpringCloudApplication = @SpringBootApplication + @EnableDiscoveryClient + @EnableCircuitBreaker
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 9:04
 */
@EnableFeignClients
@SpringCloudApplication
@EnableHystrixDashboard
@RibbonClient(name = "product-service", configuration = CustomisationLoadBalanceStrategy.class)
public class RibbonOrderClientMicroservice8100 {

    public static void main(String[] args) {
        SpringApplication.run(RibbonOrderClientMicroservice8100.class, args);
    }

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
