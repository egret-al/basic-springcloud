package com.springcloud.controller;

import com.springcloud.domain.Product;
import com.springcloud.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 12:21
 */
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/api/v1/product")
public class ProductController {

    @Value("${server.port}")
    private String port;

    @Value("${env}")
    private String environment;

    @Autowired
    private ProductService productService;

    @RequestMapping("list")
    public Object getAllProduct() {
        return productService.getAllProduct();
    }

    @RequestMapping("find/{id}")
    public Object getProductById(@PathVariable("id") Integer id) {
//        try {
//            TimeUnit.SECONDS.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        log.info("product-service port: " + port + " getProductById");
        Product product = productService.getProductById(id);
        Product res = new Product();
        if (product != null) {
            BeanUtils.copyProperties(product, res);
            res.setName(res.getName() + ", data from " + port + " port, environment: " + environment);
        } else {
            res.setName("bean is null, data from " + port + " port");
        }
        return res;
    }
}
