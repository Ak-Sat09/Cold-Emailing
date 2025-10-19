package com.example.Cold_Emailing.services.impl;

import java.util.Date;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Service;

import com.example.Cold_Emailing.dtos.EmailRequestDto;
import com.example.Cold_Emailing.services.EmailService;
import com.example.Cold_Emailing.utils.NameExtractor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final TaskScheduler taskScheduler; // For scheduling emails

    @SuppressWarnings("deprecation")
    @Override
    public void sendEmails(EmailRequestDto request) {
        // Schedule the email to be sent at the given Instant
        taskScheduler.schedule(() -> {
            for (String recipient : request.getEmails()) {
                String name = NameExtractor.extractName(recipient);
                String body = (name.isBlank() ? "Hi,\n\n" : "Hi " + name + ",\n\n") + request.getMessage();

                SimpleMailMessage msg = new SimpleMailMessage();
                msg.setTo(recipient);
                msg.setSubject(request.getSubject());
                msg.setText(body);

                mailSender.send(msg);
                System.out.println("Email sent to: " + recipient + " at " + java.time.Instant.now());
            }
        }, Date.from(request.getScheduledTime())); // Convert Instant -> Date
    }
}
