package com.example.mortgage.model;

import lombok.Data;

/**
 * Represents a loan with essential details for mortgage calculation.
 */
@Data
public class Loan {
    private double loanAmount;
    private double interestRate;
    private int loanDuration;
}
