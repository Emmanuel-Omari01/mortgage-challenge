package com.example.mortgage.view.responseDto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorHandlingDto {
    private String message;
    private String path;
}
