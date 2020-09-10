package com.atldy.springcloud.service;

import com.atldy.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author 唐多山
 * @create 2020-08-28 18:50
 */
public interface PaymentSrvice {
    int create(Payment payment);

    Payment findPaymentById(Long id);
}
