package com.example.Cold_Emailing.mapper;

import com.example.Cold_Emailing.entities.Email;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class EmailMapper {

    public static Email toEntity(String emailStr, String company) {
        return Email.builder()
                .email(emailStr)
                .companyName(company)
                .build();
    }
}