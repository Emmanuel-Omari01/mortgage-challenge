package com.example.mortgage.service.mortgageService;

public interface MortgageService {
  double calculateMonthlyPayment(
      double loanAmount, double annualInterestRate, int loanDurationYears);

  double calculateTotalPayment(double monthlyPayment, int loanDurationYears);

  double calculateTotalInterest(double totalPayment, double loanAmount);
}
