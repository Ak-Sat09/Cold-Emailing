package com.example.Cold_Emailing.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDto<T> {
    private boolean success;
    private String message;
    private T data;
}