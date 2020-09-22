package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 唐多山
 * @create 2020-09-20 20:01
 */
@SpringBootApplication
@EnableEurekaClient
public class GatewayMaill9527 {
     public static void main(String[] args) {
             SpringApplication.run(GatewayMaill9527.class,args);
         }
}
