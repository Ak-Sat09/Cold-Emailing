package com.example.Cold_Emailing.controllers;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.example.Cold_Emailing.dtos.ResponseDto;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Validated
public class EmailController {

    @GetMapping
    public String hello() {
        return "Hello, World!";
    }

    @GetMapping("/hello")
    public String hellos() {
        return "Hello, World!";
    }

    @GetMapping("/hello1")
    public String hellos1() {
        return "Hello, World! I am Anmol Mehla";
    }

    @GetMapping("/em")
    public ResponseEntity<ResponseDto<String>> getAllEmails() {
        return ResponseEntity.ok(
                ResponseDto.<String>builder()
                        .success(true)
                        .data("Hello World I am Anmol Mehla")
                        .build());
    }

}
