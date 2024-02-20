package com.example.mortgage.service.mortgageService;

import com.example.mortgage.view.responseDto.CompareLoansDto;
import com.example.mortgage.view.responseDto.LoanDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Service
@RequiredArgsConstructor
public class LoanComparisonService {
    private final MortgageService mortgageService;
    private final Lock lock = new ReentrantLock();

    public CompareLoansDto compareLoans(List<LoanDto> loanDtos) {
        CompareLoansDto compareLoansDto = new CompareLoansDto();
        List<LoanDto> loans = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(loanDtos.size());

        for (LoanDto loanDto : loanDtos) {
            executorService.submit(() -> {
                try {
                    lock.lock();
                    LoanDto resultDto = calculateLoanDetails(loanDto);
                    loans.add(resultDto);
                } finally {
                    lock.unlock();
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread()
                    .interrupt();
        }

        compareLoansDto.setLoans(loans);
        return compareLoansDto;
    }

    private LoanDto calculateLoanDetails(LoanDto loanDto) {
        double monthlyPayment = mortgageService.calculateMonthlyPayment(loanDto);
        double totalPayment = mortgageService.calculateTotalPayment(monthlyPayment, loanDto.getLoanDuration());
        double totalInterest = mortgageService.calculateTotalInterest(totalPayment, loanDto.getLoanAmount());

        LoanDto resultDto = new LoanDto();
        resultDto.setLoanAmount(loanDto.getLoanAmount());
        resultDto.setInterestRate(loanDto.getInterestRate());
        resultDto.setLoanDuration(loanDto.getLoanDuration());
        resultDto.setMonthlyPayment(monthlyPayment);
        resultDto.setTotalPayment(totalPayment);
        resultDto.setTotalInterest(totalInterest);

        return resultDto;
    }
}