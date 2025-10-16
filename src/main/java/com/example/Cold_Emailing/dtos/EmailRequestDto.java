package com.example.Cold_Emailing.dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmailRequestDto {
    @NotEmpty(message = "emails must not be empty")
    private List<@Email(message = "invalid email") String> emails;

    @NotBlank(message = "subject required")
    private String subject;

    @NotBlank(message = "message required")
    private String message;
}