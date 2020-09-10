package com.com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-10 9:36
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMail8006 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMail8006.class, args);
    }
}
