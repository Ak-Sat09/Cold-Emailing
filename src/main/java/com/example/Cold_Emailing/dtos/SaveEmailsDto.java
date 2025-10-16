package com.example.Cold_Emailing.dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SaveEmailsDto {
    @NotEmpty(message = "emails must not be empty")
    private List<@Email(message = "invalid email") String> emails;
}