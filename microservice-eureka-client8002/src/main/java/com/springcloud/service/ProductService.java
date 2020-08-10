package com.springcloud.service;

import com.springcloud.domain.Product;

import java.util.List;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 12:22
 */
public interface ProductService {

    List<Product> getAllProduct();

    Product getProductById(Integer id);
}
