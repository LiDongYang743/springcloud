package com.atldy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author 唐多山
 * @create 2020-09-14 11:06
 */
@SpringBootApplication
@EnableEurekaClient
public class PaymentHsytrixMail8001 {
     public static void main(String[] args) {
             SpringApplication.run(PaymentHsytrixMail8001.class,args);
         }
}
