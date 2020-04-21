package com.example.demo2.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class LogConfig {

    private static final Logger log = LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public void logMethod() {
        log.warn("==========start log==========");
    }
}
