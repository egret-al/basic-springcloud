package com.springcloud.service;

import com.springcloud.domain.ProductOrder;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 9:13
 */
public interface ProductOrderService {

    ProductOrder save(Integer userId, Integer productId);
}
