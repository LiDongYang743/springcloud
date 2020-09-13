package com.atldy.springcloud.controller;

import com.atldy.springcloud.domain.CommonResult;
import com.atldy.springcloud.domain.Payment;
import com.atldy.springcloud.lb.Loadbalancer;
import com.netflix.discovery.converters.Auto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

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

    @Autowired
    private Loadbalancer loadbalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/consumer/payment/lb")
    public String paymentUrl(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null|| instances.size()<=0){
            return null;
        }
        ServiceInstance serviceInstance = loadbalancer.instance(instances);
        URI uri = serviceInstance.getUri();
        return restTemplate.getForObject(uri+"/payment/lb",String.class);
    }


}
