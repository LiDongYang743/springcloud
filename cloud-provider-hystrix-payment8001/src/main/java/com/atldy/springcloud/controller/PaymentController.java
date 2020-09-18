package com.atldy.springcloud.controller;

import com.atldy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐多山
 * @create 2020-09-14 11:12
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.getPayment(id);
        log.info("*****result:" + result);
        return result;
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
        String result = paymentService.getOutTime(id);
        log.info("*****result:" + result);
        return result;

    }

    //服务熔断
    @GetMapping("/payment/hystrix/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String breaker = paymentService.paymentCircuitBreaker(id);
        return breaker;
    }

}
