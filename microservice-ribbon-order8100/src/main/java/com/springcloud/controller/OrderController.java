package com.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.springcloud.domain.ProductOrder;
import com.springcloud.service.ProductOrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author rkc
 * @version 1.0
 * @date 2020/8/7 9:12
 */
@Slf4j
@RestController
@RefreshScope
@RequestMapping("/api/v1/order")
public class OrderController {

    @Autowired
    private ProductOrderService productOrderService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("save/{user_id}/{product_id}")
    @HystrixCommand(fallbackMethod = "saveOrderFail")
    public Object save(@PathVariable("user_id") Integer userId, @PathVariable("product_id") Integer productId
            , HttpServletRequest request) {
        String token = request.getHeader("token");
        String cookie = request.getHeader("cookie");
        log.info("token=" + token + ", cookie=" + cookie);

        ProductOrder res = productOrderService.save(userId, productId);
        Map<String, Object> map = new HashMap<>();
        map.put("code", 200);
        map.put("msg", "操作成功");
        map.put("data", res);
        return map;
    }

    //方法参数要和@HystrixCommand标注的方法参数一致
    private Object saveOrderFail(Integer userId, Integer productId, HttpServletRequest request) {
        //监控报警
        String saveOrderKey = "save-order";
        String sendValue = redisTemplate.opsForValue().get(saveOrderKey);
        final String ipAddr = request.getRemoteAddr();
        //使用线程池进行发送短信
        ExecutorService pool = Executors.newFixedThreadPool(5);
        pool.submit(() -> {
            if (StringUtils.isBlank(sendValue)) {
                log.error("紧急短信：用户下单失败，请立刻查找原因！！！失败地址：" + ipAddr);
                //发送短信操作通知开发人员，TODO
                //发送成功
                redisTemplate.opsForValue().set(saveOrderKey, "save-order-fail", 20, TimeUnit.SECONDS);
            } else {
                log.info("已经发送过短信，20秒内不重复发送短信");
            }
        });
        pool.shutdown();
        Map<String, Object> map = new HashMap<>();
        map.put("code", -1);
        map.put("msg", "抢购人数过多，稍等重试");
        return map;
    }
}
