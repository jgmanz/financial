package com.accenture.financial.service;
 

import com.accenture.financial.model.Account;
import com.accenture.financial.repository.SpendingTransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpendingTransactionService {
    @Autowired
    private final SpendingTransactionRepository spendingTransactionRepository;
    
    public SpendingTransactionService( SpendingTransactionRepository spendingTransactionRepository)
    {
        this.spendingTransactionRepository = spendingTransactionRepository;
    }

    public double getThisYearSpendingAmount(Account account)
    { 
        return spendingTransactionRepository.getSpendingLastYear(account);
    }

    public double getLastYearSpendingAmount(Account account)
    { 
        return spendingTransactionRepository.getSpendingLastYear(account);
    }



}
