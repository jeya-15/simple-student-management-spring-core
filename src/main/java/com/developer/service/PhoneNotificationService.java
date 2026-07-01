package com.developer.service;

import org.springframework.stereotype.Service;

@Service
public class PhoneNotificationService implements NotificationService {

    @Override
    public void send(String recipient, String msg) throws InterruptedException {
        System.out.println("Message to the number " + recipient + " is initiated");
        System.out.println("Sending");
        Thread.sleep(2000);
        System.out.println("Message successfully sent to " + recipient);
    }
}
