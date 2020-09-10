package com.atldy.springcloud.mapper;

import com.atldy.springcloud.domain.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author 唐多山
 * @create 2020-08-28 17:24
 */
@Mapper
@Repository
public interface PaymentMapper {

    int create(Payment payment);

    Payment findPaymentById(@Param("id") Long id);

}
