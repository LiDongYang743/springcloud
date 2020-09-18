package com.atldy.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atldy.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author 唐多山
 * @create 2020-09-14 11:09
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    //正常方法
    @Override
    public String getPayment(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + " paymentInfo_OK,id:" + id + "\t" + "O(∩_∩)O哈哈~";
    }

    //    超时方法
    @Override
    @HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHeand", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
    })
    public String getOutTime(Integer id) {
        int timeNumber = 3;
        try {
            // 暂停3秒钟
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        int i=10/0;
        return "线程池:" + Thread.currentThread().getName() + "\t" + id + "\t" + "O(∩_∩)O哈哈~  耗时(秒)" + timeNumber;
    }

    //    服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //circuitBreaker.enabled ：开启服务熔断
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),//circuitBreaker.requestVolumeThreshold：服务调用次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),//circuitBreaker.sleepWindowInMilliseconds：时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60") //失败率达到多少后跳闸
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id) {
        if (id < 0) {
            throw new RuntimeException("*********id不能负数*****");
        }
        String uid = IdUtil.fastSimpleUUID();
        return Thread.currentThread().getName() + "\t" + "调用流水号:" + uid;
    }


    //    服务降级：兜底方法
    public String paymentInfo_TimeOutHeand(Integer id) {
        return "线程池:" + Thread.currentThread().getName() + "\t" + "     8001系统繁忙运行超时或运行出错,请等候再试！,id:" + id + "\t" + "        落泪~ ";
    }

//    服务熔断:
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能为负数，请稍后访问》》》---id："+id;
    }

}
