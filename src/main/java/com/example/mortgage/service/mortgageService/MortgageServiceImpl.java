package com.example.mortgage.service.mortgageService;

import com.example.mortgage.view.responseDto.LoanDto;
import org.springframework.stereotype.Service;

/**
 * Implementation of the MortgageService interface for performing mortgage calculations.
 */
@Service
public class MortgageServiceImpl implements MortgageService {
  private static final int MONTHS_PER_YEAR = 12;
  @Override
  public double calculateMonthlyPayment(
          LoanDto loanDto) {
    double monthlyInterestRate =
        loanDto.getInterestRate() / MONTHS_PER_YEAR / 100; // Convert annual interest rate to monthly
    int numberOfPayments = loanDto.getLoanDuration() * MONTHS_PER_YEAR;

    // Calculate monthly payment using the formula for a fixed-rate mortgage
    double monthlyPayment =
        loanDto.getLoanAmount()
            * monthlyInterestRate
            / (1 - Math.pow(1 + monthlyInterestRate, -numberOfPayments));

    return monthlyPayment;
  }

  @Override
  public double calculateTotalPayment(double monthlyPayment, int loanDurationYears) {
    return monthlyPayment * loanDurationYears * MONTHS_PER_YEAR;
  }

  @Override
  public double calculateTotalInterest(double totalPayment, double loanAmount) {
    return totalPayment - loanAmount;
  }
}
