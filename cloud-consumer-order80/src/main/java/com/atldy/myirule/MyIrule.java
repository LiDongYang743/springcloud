package com.atldy.myirule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 唐多山
 * @create 2020-09-10 17:13
 */
@Configuration
public class MyIrule {

    @Bean
    public IRule rule(){
        return new RandomRule();
    }

}
