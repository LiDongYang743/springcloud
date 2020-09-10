package com.atldy.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 唐多山
 * @create 2020-09-10 10:13
 */
@RestController
public class OrederController {

    public final static String INVOK_URL = "http://cloud-providerconsul-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/order/consul")
    public String orderConsul() {
        return restTemplate.getForObject(INVOK_URL + "/payment/consul", String.class);
    }
}
