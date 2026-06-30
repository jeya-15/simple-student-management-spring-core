package com.developer.config;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.developer")
public class AppConfig {
    private static final Logger logger =
            LoggerFactory.getLogger(AppConfig.class);

    @PostConstruct
    public void init(){
        logger.info("AppConfig created!");
    }

}
