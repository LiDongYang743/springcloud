package com.atldy.springcloud.controller;

import com.atldy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐多山
 * @create 2020-09-14 22:54
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Autowired
    private PaymentService paymentService;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer//payment/hystrix/ok/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("*****result:" + result);
        return result;
    }


    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")})
//    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("id") Integer id) {
//        int i=10/0;
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*****result:" + result);
        return result;
    }

    public String paymentTimeOutFallbackMethod(@PathVariable("id") Integer id) {
        return "我是消费者80,对方支付系统繁忙请10秒种后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全局fallback
     *
     * @return
     */
    public String payment_Global_FallbackMethod() {
        return "Global异常处理信息,请稍后重试.o(╥﹏╥)o";
    }
}
