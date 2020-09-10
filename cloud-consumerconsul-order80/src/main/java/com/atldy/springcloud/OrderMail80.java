package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-10 10:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMail80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMail80.class, args);
    }
}
