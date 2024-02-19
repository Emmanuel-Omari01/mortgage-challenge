package com.example.mortgage.model;

import lombok.Data;

@Data
public class Loan {
    private double loanAmount;
    private double interestRate;
    private int loanDuration;
}
