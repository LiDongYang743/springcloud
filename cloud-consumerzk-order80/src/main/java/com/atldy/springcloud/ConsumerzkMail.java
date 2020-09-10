package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-09 21:38
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConsumerzkMail {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerzkMail.class,args);
    }
}
