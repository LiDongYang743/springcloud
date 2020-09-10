package com.atldy.springcloud.controller;

import com.atldy.springcloud.domain.CommonResult;
import com.atldy.springcloud.domain.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 唐多山
 * @create 2020-08-29 17:53
 */
@RestController
@Slf4j
public class OrderController {

//    public static final String  PAYMENY_URL="http://localhost:8001";
      public static final String  PAYMENY_URL="http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment){
        log.info("执行成功***"+payment+payment);
        return restTemplate.postForObject(PAYMENY_URL+"/payment/create",payment,CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id){
        log.info("***执行成功");
        return restTemplate.getForObject(PAYMENY_URL+"/payment/get/"+id,CommonResult.class);
    }

}
