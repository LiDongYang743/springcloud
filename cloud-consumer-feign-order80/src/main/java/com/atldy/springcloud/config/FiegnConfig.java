package com.atldy.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 唐多山
 * @create 2020-09-13 16:17
 */
@Configuration
public class FiegnConfig {

    @Bean
    public Logger.Level getLogger() {
        return Logger.Level.FULL;
    }

}
