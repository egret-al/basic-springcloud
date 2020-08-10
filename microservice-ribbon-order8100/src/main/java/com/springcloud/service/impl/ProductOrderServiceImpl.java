package com.springcloud.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.springcloud.domain.ProductOrder;
import com.springcloud.service.ProductInvokingInterface;
import com.springcloud.service.ProductOrderService;
import com.springcloud.util.JsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;
import java.util.UUID;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 9:13
 */
@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    @Autowired
    private ProductInvokingInterface productInvokingInterface;

    @Override
    public ProductOrder save(Integer userId, Integer productId) {
        String resStr = productInvokingInterface.findById(productId);
        JsonNode jsonNode = JsonUtil.stringToJsonNode(resStr);

        ProductOrder productOrder = new ProductOrder();
        productOrder.setCreateTime(new Date());
        productOrder.setUserId(userId);
        productOrder.setTradeNo(UUID.randomUUID().toString());
        productOrder.setProductName(jsonNode.get("name").toString());
        productOrder.setPrice(Float.parseFloat(jsonNode.get("price").toString()));

        return productOrder;
    }
}
