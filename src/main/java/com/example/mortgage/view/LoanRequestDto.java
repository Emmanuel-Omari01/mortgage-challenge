package com.example.mortgage.view;

import com.example.mortgage.model.LoanType;
import com.example.mortgage.model.PaymentFrequency;
import lombok.Data;

@Data
public class LoanRequestDto {
    private double loanAmount;
    private double interestRate;
    private int loanDuration;
    private LoanType loanType;
    private PaymentFrequency paymentFrequency;
}
