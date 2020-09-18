package com.atldy.springcloud.fallbock;

import com.atldy.springcloud.service.PaymentService;
import org.springframework.stereotype.Component;

/**
 * @author 唐多山
 * @create 2020-09-17 14:51
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "-----------PaymentFallbackService fall paymentInfo_OK-----";
    }

    @Override
    public String paymentInfo_TimeOut(Integer id) {
        return "--------- PaymentFallbackService fall paymentInfo_TimeOut---- ";
    }
}
