package com.atldy.springcloud.controller;

import com.atldy.springcloud.domain.CommonResult;
import com.atldy.springcloud.domain.Payment;
import com.atldy.springcloud.service.PaymentSrvice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 唐多山
 * @create 2020-08-28 18:50
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentSrvice paymentSrvice;

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/payment/create")
    public CommonResult<Integer>  create(@RequestBody Payment payment){
        int result = paymentSrvice.create(payment);
        log.info("****插入日志信息"+result);
        if (result>0){
            return new CommonResult<>(200,"插入数据成功,serverPort:"+serverPort,result);
        }else {
            return new CommonResult<>(444,"插入数据失败",null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public  CommonResult<Payment> findPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentSrvice.findPaymentById(id);
        log.info("****查询结果"+payment);
        if (payment!=null){
            return new CommonResult<>(200,"查询成功,serverPort:"+serverPort,payment);
        }else {
            return new CommonResult<>(444,"查询失败，查询ID为："+id,null);
        }
    }

    @GetMapping("/payment/discovery")
    public Object  discovery(){
        List<String> services = discoveryClient.getServices(); //获取注册的服务
        for (String service : services) {
            log.info("***"+service);
        }

        List<ServiceInstance> instances = discoveryClient.getInstances("Cloud-payment-service");
        for (ServiceInstance instance : instances) {
            log.info("****"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri()+"\t"+instance.getScheme());
        }

        return this.discoveryClient;
    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/payment/time")
    public String getTime() {
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return serverPort;
    }
}
