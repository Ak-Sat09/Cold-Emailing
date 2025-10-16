package com.example.Cold_Emailing.services.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.example.Cold_Emailing.dtos.EmailRequestDto;
import com.example.Cold_Emailing.entities.EmailSent;
import com.example.Cold_Emailing.mapper.EmailMapper;
import com.example.Cold_Emailing.repositories.EmailRepository;
import com.example.Cold_Emailing.repositories.EmailSentRepository;
import com.example.Cold_Emailing.services.EmailService;
import com.example.Cold_Emailing.utils.NameExtractor;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;
    private final EmailRepository emailRepository;
    private final EmailSentRepository emailSentRepository;

    @Override
    public void sendEmails(EmailRequestDto request) {
        for (String recipent : request.getEmails()) {
            String name = NameExtractor.extractName(recipent);
            String body = (name.isBlank() ? "Hi,\n\n" : "Hi " + name + ",\n\n") + request.getMessage();

            SimpleMailMessage msg = new SimpleMailMessage();

            msg.setTo(recipent);
            msg.setSubject(request.getSubject());
            msg.setText(body);

            emailSentRepository.findByEmail(recipent)
                    .ifPresentOrElse(sent -> {
                        sent.setSentAt(LocalDateTime.now());
                        emailSentRepository.save(sent);
                    }, () -> emailSentRepository.save(EmailSent.builder()
                            .email(recipent)
                            .sentAt(LocalDateTime.now())
                            .build()));
            mailSender.send(msg);
        }
    }

    @Override
    public void saveEmails(List<String> emails) {
        for (String raw : emails) {
            if (raw == null || raw.isBlank())
                continue;
            String email = raw.trim().toLowerCase();
            if (emailRepository.existsByEmail(email))
                continue;
            String company = NameExtractor.extractCompany(email);
            emailRepository.save(EmailMapper.toEntity(email, company));

        }
    }
}
