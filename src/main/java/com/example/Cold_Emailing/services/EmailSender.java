package com.example.Cold_Emailing.services;

import org.springframework.mail.SimpleMailMessage;

public interface EmailSender {
    void send(SimpleMailMessage message);
}