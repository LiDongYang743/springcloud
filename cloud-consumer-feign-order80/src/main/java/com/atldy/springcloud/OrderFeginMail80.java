package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 唐多山
 * @create 2020-09-13 15:31
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeginMail80 {
     public static void main(String[] args) {
             SpringApplication.run(OrderFeginMail80.class,args);
         }
}
