package com.atldy.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 唐多山
 * @create 2020-09-09 21:41
 */
@RestController
public class ConsumezkController {

    public static final String INVOKE_URL="http://Cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/Consume/zk")
    public String getInvokeUrl(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }

}
