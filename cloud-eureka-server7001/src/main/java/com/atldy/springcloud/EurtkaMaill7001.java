package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 唐多山
 * @create 2020-08-29 22:21
 */
@SpringBootApplication
@EnableEurekaServer
public class EurtkaMaill7001 {
    public static void main(String[] args) {
        SpringApplication.run(EurtkaMaill7001.class,args);
    }
}
