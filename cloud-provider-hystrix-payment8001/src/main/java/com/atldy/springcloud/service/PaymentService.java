package com.atldy.springcloud.service;

import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 唐多山
 * @create 2020-09-14 11:07
 */
public interface PaymentService {

    //    正常方法
    String getPayment(Integer id);

    //    超时方法
    String getOutTime(Integer id);

    //服务熔断
    String paymentCircuitBreaker(Integer id);

}
