package com.example.mortgage.controller;

import com.example.mortgage.service.mortgageService.MortgageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/** Controller class responsible for handling mortgage calculation endpoints. */
@RestController
@RequestMapping("/api/v1/mortgage")
@RequiredArgsConstructor
public class MortgageController {
  private final MortgageService mortgageService;

  /**
   * Calculate the monthly payment for a mortgage.
   *
   * @param loanAmount the amount of the loan
   * @param annualInterestRate the annual interest rate
   * @param loanDurationYears the duration of the loan in years
   * @return the monthly payment
   */
  @ResponseStatus(HttpStatus.OK)
  @GetMapping("/calculateMonthlyPayment")
  public double calculateMonthlyPayment(
      @RequestParam double loanAmount,
      @RequestParam double annualInterestRate,
      @RequestParam int loanDurationYears) {
    return mortgageService.calculateMonthlyPayment(
        loanAmount, annualInterestRate, loanDurationYears);
  }
}
