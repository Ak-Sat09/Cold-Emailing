package com.example.Cold_Emailing.services;

import com.example.Cold_Emailing.dtos.EmailRequestDto;

public interface EmailService {
    void sendEmails(EmailRequestDto request);

}
