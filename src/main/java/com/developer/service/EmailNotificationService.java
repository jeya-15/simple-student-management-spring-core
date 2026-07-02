package com.developer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@Qualifier("email")
public class EmailNotificationService implements NotificationService {
    private final Logger logger = LoggerFactory.getLogger(EmailNotificationService.class);

    @Override
    public void send(String recipient, String msg) throws InterruptedException {
        System.out.println("Mail to " + recipient + " is initiated");
        System.out.println("Sending the message : " + msg);
        Thread.sleep(2000);
        System.out.println("Mail successfully sent to " + recipient);
        logger.info("Mail successfully sent to {}", recipient);
    }

}
