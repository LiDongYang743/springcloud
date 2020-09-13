package com.atldy.springcloud;

import com.atldy.myirule.MyIrule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author 唐多山
 * @create 2020-08-29 17:49
 */
@SpringBootApplication
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MyIrule.class)
public class ConsumerOrder80Application {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Application.class,args);
    }

}
