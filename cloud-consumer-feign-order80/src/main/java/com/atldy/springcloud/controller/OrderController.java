package com.atldy.springcloud.controller;

import com.atldy.springcloud.domain.CommonResult;
import com.atldy.springcloud.domain.Payment;
import com.atldy.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 唐多山
 * @create 2020-09-13 15:37
 */
@RestController
public class OrderController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("consumer/payment/get/{id}")
    public CommonResult<Payment> payment(@PathVariable("id") Long id){

        return paymentService.findPaymentById(id);
    }

    @GetMapping(value = "consumer/payment/time")
    public String getTime(){
        return  paymentService.getTime();
    }

}
