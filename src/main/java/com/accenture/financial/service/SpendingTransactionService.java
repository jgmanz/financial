package com.accenture.financial.service;
 

import com.accenture.financial.model.Account;
import com.accenture.financial.repository.SpendingTransactionRepository;

import javafx.util.converter.LocalDateStringConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Service
public class SpendingTransactionService {
    @Autowired
    private final SpendingTransactionRepository spendingTransactionRepository;
    
    public SpendingTransactionService( SpendingTransactionRepository spendingTransactionRepository)
    {
        this.spendingTransactionRepository = spendingTransactionRepository;
    }

    public double getRollingYearSpendingAmount(Account account)
    {
        LocalDate openDate = account.getOpenDate();
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.minusYears(1);
        int monthDiff = getDiffMonths(openDate.withDayOfMonth(1), today.withDayOfMonth(1));
        //Get spending amount
        double rollingYearAmount = spendingTransactionRepository.getSpendingAmount(account, lastYear, today);

        if (monthDiff < 12)
        {
            rollingYearAmount = scaleSpendingAmount( monthDiff, rollingYearAmount);
        }
        return rollingYearAmount;
    }

    public double getRollingYearMonthAvgSpendingAmount(Account account)
    {
        LocalDate openDate = account.getOpenDate();
        LocalDate today = LocalDate.now();
        LocalDate lastYear = today.minusYears(1);
        int monthDiff = getDiffMonths(openDate.withDayOfMonth(1), today.withDayOfMonth(1));
        //Get spending amount
        double rollingYearAmount = spendingTransactionRepository.getSpendingAmount(account, lastYear, today);

        if (monthDiff < 12)
        {
            rollingYearAmount = scaleSpendingAmount( monthDiff, rollingYearAmount);
        }
        return rollingYearAmount / 12;
    }
    private double scaleSpendingAmount(int months, double amount)
    {
        return (12 * amount) / months;
    }
    private int getDiffMonths(LocalDate from, LocalDate to)
    {
        Period diffMonths = Period.between(from.withDayOfMonth(1), to.withDayOfMonth(1));
        return diffMonths.getMonths();
    }
}
