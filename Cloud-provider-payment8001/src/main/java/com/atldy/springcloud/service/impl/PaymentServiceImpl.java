package com.atldy.springcloud.service.impl;

import com.atldy.springcloud.domain.Payment;
import com.atldy.springcloud.mapper.PaymentMapper;
import com.atldy.springcloud.service.PaymentSrvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 唐多山
 * @create 2020-08-28 18:51
 */
@Service
public class PaymentServiceImpl implements PaymentSrvice {

    @Autowired
    private PaymentMapper paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment findPaymentById(Long id) {
        return paymentDao.findPaymentById(id);
    }
}
