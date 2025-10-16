package com.example.Cold_Emailing.services;

import java.util.List;

import com.example.Cold_Emailing.dtos.EmailRequestDto;

public interface EmailService {
    void sendEmails(EmailRequestDto request);

    void saveEmails(List<String> emails);
}
