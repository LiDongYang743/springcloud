package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-24 19:22
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SetinelMainApp8401 {
    public static void main(String[] args) {
        SpringApplication.run(SetinelMainApp8401.class, args);
    }
}
