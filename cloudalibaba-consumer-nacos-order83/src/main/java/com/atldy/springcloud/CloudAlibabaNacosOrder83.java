package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 唐多山
 * @create 2020-09-23 15:00
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaNacosOrder83 {
    public static void main(String[] args) {
        SpringApplication.run(CloudAlibabaNacosOrder83.class, args);
    }
}
