package com.example.mortgage.service.mortgageService;

/** Interface for performing mortgage calculations. */
public interface MortgageService {
  /**
   * Calculates the monthly mortgage payment based on the loan amount, annual interest rate, and
   * loan duration.
   *
   * @param loanAmount The amount of the loan.
   * @param annualInterestRate The annual interest rate.
   * @param loanDurationYears The loan duration in years.
   * @return The calculated monthly mortgage payment.
   */
  double calculateMonthlyPayment(
      double loanAmount, double annualInterestRate, int loanDurationYears);

  /**
   * Calculates the total payment over the entire loan duration based on the monthly payment and loan duration.
   *
   * @param monthlyPayment    The monthly mortgage payment.
   * @param loanDurationYears The loan duration in years.
   * @return The total payment over the entire loan duration.
   */
  double calculateTotalPayment(double monthlyPayment, int loanDurationYears);

  /**
   * Calculates the total interest paid over the entire loan duration based on the total payment and loan amount.
   *
   * @param totalPayment The total payment over the entire loan duration.
   * @param loanAmount   The amount of the loan.
   * @return The total interest paid over the entire loan duration.
   */
  double calculateTotalInterest(double totalPayment, double loanAmount);
}
