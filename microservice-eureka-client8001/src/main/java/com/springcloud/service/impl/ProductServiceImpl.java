package com.springcloud.service.impl;

import com.springcloud.domain.Product;
import com.springcloud.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/6 12:23
 */
@Service
public class ProductServiceImpl implements ProductService {

    private static final Map<Integer, Product> daoMap = new HashMap<>();

    static {
        Product p1 = new Product(1, "iphonex", 9999f, 10);
        Product p2 = new Product(2, "冰箱", 5342f, 10);
        Product p3 = new Product(3, "洗衣机", 523f, 90);
        Product p4 = new Product(4, "电话", 1000f, 150);
        Product p5 = new Product(5, "Java编程思想", 50f, 10);
        Product p6 = new Product(6, "汽车", 120000f, 10);
        Product p7 = new Product(7, "椅子", 253f, 10);

        daoMap.put(p1.getId(), p1);
        daoMap.put(p2.getId(), p2);
        daoMap.put(p3.getId(), p3);
        daoMap.put(p4.getId(), p4);
        daoMap.put(p5.getId(), p5);
        daoMap.put(p6.getId(), p6);
        daoMap.put(p7.getId(), p7);
    }

    @Override
    public List<Product> getAllProduct() {
        Collection<Product> collection = daoMap.values();
        List<Product> list = new ArrayList<>(collection);
        return list;
    }

    @Override
    public Product getProductById(Integer id) {
        return daoMap.get(id);
    }
}
