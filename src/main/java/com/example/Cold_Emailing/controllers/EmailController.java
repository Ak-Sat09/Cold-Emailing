package com.example.Cold_Emailing.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Cold_Emailing.dtos.EmailRequestDto;
import com.example.Cold_Emailing.dtos.ResponseDto;
import com.example.Cold_Emailing.dtos.SaveEmailsDto;
import com.example.Cold_Emailing.services.EmailService;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class EmailController {

    private final EmailService emailService;

    @PostMapping("/email")
    public ResponseEntity<ResponseDto<Void>> sendEmail(@RequestBody @Validated EmailRequestDto request) {
        emailService.sendEmails(request);
        return ResponseEntity.ok(ResponseDto.<Void>builder().success(true).message("Emails sent").build());
    }

    @PostMapping("/save")
    public ResponseEntity<ResponseDto<Void>> saveEmails(@RequestBody @Validated SaveEmailsDto request) {
        emailService.saveEmails(request.getEmails());
        return ResponseEntity.ok(ResponseDto.<Void>builder().success(true).message("Emails saved").build());
    }
}
