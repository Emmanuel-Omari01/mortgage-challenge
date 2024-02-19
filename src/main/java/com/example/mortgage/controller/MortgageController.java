package com.example.mortgage.controller;

import com.example.mortgage.service.mortgageService.MortgageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/mortgage")
@RequiredArgsConstructor
public class MortgageController {
  private final MortgageService mortgageService;

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
