package com.upstreamsystems.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class AppConfig {

    @Bean
    public ThreadPoolExecutor taskExecutor() {
        return (ThreadPoolExecutor)Executors.newFixedThreadPool(15000);
    }

}
