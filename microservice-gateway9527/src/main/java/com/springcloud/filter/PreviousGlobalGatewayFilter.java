package com.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/8 19:36
 */
@Slf4j
@Component
public class PreviousGlobalGatewayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("1、PreviousGlobalGatewayFilter过滤器执行");
        ServerHttpRequest request = exchange.getRequest();
        HttpHeaders headers = request.getHeaders();
        if (headers.containsKey("token")) {
            log.info("已经登录");
        } else {
            log.error("未登录");
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        //返回值越小，则过滤器就越先执行
        return 0;
    }
}
