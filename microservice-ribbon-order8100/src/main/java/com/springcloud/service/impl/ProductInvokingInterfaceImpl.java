package com.springcloud.service.impl;

import com.springcloud.service.ProductInvokingInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/8 8:46
 */
@Slf4j
@Component
public class ProductInvokingInterfaceImpl implements ProductInvokingInterface {

    @Override
    public String findById(Integer id) {
        log.warn("feign调用product-service发生了异常");
        return null;
    }
}
