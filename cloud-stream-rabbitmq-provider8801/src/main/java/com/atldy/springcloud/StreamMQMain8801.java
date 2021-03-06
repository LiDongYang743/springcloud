package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 唐多山
 * @create 2020-09-22 19:22
 */
@SpringBootApplication
@EnableEurekaClient
public class StreamMQMain8801 {
     public static void main(String[] args) {
             SpringApplication.run(StreamMQMain8801.class,args);
         }
}
