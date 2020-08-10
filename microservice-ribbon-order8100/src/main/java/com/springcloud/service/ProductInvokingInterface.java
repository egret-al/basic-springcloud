package com.springcloud.service;

import com.springcloud.service.impl.ProductInvokingInterfaceImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 10:47
 */
@FeignClient(name = "product-service", fallback = ProductInvokingInterfaceImpl.class)
public interface ProductInvokingInterface {

    @GetMapping("/api/v1/product/find/{id}")
    String findById(@PathVariable("id") Integer id);
}
