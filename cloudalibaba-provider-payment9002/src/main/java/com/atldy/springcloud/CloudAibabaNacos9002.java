package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-23 14:52
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAibabaNacos9002 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAibabaNacos9002.class, args);
    }
}
