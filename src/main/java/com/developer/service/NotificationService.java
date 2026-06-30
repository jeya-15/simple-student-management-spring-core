package com.developer.service;

public interface NotificationService {
    void send(String recipient, String msg) throws InterruptedException;
}
