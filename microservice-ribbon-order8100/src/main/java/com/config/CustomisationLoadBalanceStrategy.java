package com.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 10:31
 */
@Configuration
public class CustomisationLoadBalanceStrategy {

    @Bean
    public IRule rule() {
        return new RandomRule();
    }
}
