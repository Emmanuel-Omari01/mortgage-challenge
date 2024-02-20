package com.example.mortgage.view.responseDto;

import lombok.Data;

import java.util.List;

@Data
public class CompareLoansDto {
    List<LoanDto> loans;
}
