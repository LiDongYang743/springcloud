package com.atldy.springcloud.service;

/**
 * @author 唐多山
 * @create 2020-09-14 11:07
 */
public interface PaymentService {

//    正常方法
    String getPayment(Integer id);

//    超时方法
    String getOutTime(Integer id);

}
