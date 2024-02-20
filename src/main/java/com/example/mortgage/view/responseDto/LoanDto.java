package com.example.mortgage.view.responseDto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class LoanDto {

    private double loanAmount;
    private double interestRate;
    private int loanDuration;
    private double monthlyPayment;
    private double totalPayment;
    private double totalInterest;
}
