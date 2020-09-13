package com.atldy.springcloud.service;

import com.atldy.springcloud.domain.CommonResult;
import com.atldy.springcloud.domain.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author 唐多山
 * @create 2020-09-13 15:31
 */
@Component
@FeignClient("CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping("/payment/get/{id}")
    CommonResult<Payment> findPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/time")
    String getTime();
}
