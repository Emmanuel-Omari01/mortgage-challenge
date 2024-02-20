package com.example.mortgage.controller;

import com.example.mortgage.service.mortgageService.LoanComparisonService;
import com.example.mortgage.service.mortgageService.MortgageService;
import com.example.mortgage.view.responseDto.CompareLoansDto;
import com.example.mortgage.view.responseDto.LoanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Controller class responsible for handling mortgage calculation endpoints.
 */
@RestController
@RequestMapping("/api/v1/mortgage")
@RequiredArgsConstructor
public class MortgageController {
    private final MortgageService mortgageService;
    private final LoanComparisonService loanComparisonService;

    /**
     * Calculate the monthly payment for a mortgage.
     *
     * @return the monthly payment
     */
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/calculateMonthlyPayment")
    public double calculateMonthlyPayment(@RequestBody LoanDto loanDto) {
        return mortgageService.calculateMonthlyPayment(loanDto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/compare")
    public CompareLoansDto compareLoans(@RequestBody CompareLoansDto compareLoansDto) {
        return loanComparisonService.compareLoans(compareLoansDto.getLoans());

    }




}
