package com.accenture.financial.controller;

import com.accenture.financial.model.Account;
import com.accenture.financial.service.AccountService;
import com.accenture.financial.service.SpendingTransactionService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/spendingtransaction")
public class SpendingTransactionController {
    @Autowired
    private final SpendingTransactionService spendingTransactionService;

    @Autowired
    private final AccountService accountService;

    public SpendingTransactionController(SpendingTransactionService spendingTransactionService, AccountService accountService)
    {
        this.spendingTransactionService = spendingTransactionService;
        this.accountService = accountService;
    }

    @GetMapping(value="/spending/rollingyear")
    //rolling year
    public double getSpendingAmountThisYear(@RequestParam Long accountId) {
        Account account = accountService.getById(accountId);
        return spendingTransactionService.getRollingYearSpendingAmount(account);
    }
    
    @GetMapping(value="/spending/monthavg")
    //last year
    public double getSpendingAmountLastYear(@RequestParam Long accountId) {
        Account account = accountService.getById(accountId);
        return spendingTransactionService.getRollingYearMonthAvgSpendingAmount(account);
    }
}

/*
JUNIT
 */
