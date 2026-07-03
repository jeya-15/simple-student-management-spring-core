package com.developer.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("phone")
public class PhoneNotificationService implements NotificationService {

    private final Logger logger = LoggerFactory.getLogger(PhoneNotificationService.class);


    @PostConstruct
    public void init() {
        logger.info("Phone notification service is created");
    }

    @PreDestroy
    public void destroy() {
        logger.info("Phone notification service is destroyed");
    }

    @Override
    public void send(String recipient, String msg) throws InterruptedException {
        System.out.println("Message to the number " + recipient + " is initiated");
        System.out.println("Sending");
        Thread.sleep(2000);
        System.out.println("Message successfully sent to " + recipient);
        logger.info("Message successfully sent to {}", recipient);

    }
}
