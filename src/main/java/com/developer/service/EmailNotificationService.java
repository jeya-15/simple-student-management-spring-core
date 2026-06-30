package com.developer.service;

import org.springframework.stereotype.Service;

@Service
public class EmailNotificationService implements NotificationService{
    @Override
    public void send(String recipient, String msg) throws InterruptedException {
        System.out.println("Mail to "+recipient+" is initiated");
        System.out.println("Sending");
        Thread.sleep(2000);
        System.out.println("Mail successfully sent to "+recipient);
    }
}
