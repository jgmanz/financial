package com.accenture.financial.service;

import java.util.List;

import com.accenture.financial.model.Account;
import com.accenture.financial.repository.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    
    @Autowired
    private final AccountRepository accountRepository;
    public AccountService(AccountRepository accountRepository)
    {
        this.accountRepository = accountRepository;
    }

    public List<Account> listAccounts()
    {
        return accountRepository.findAll();
    }

    public Account getById(Long id){
        return accountRepository.getById(id);
    }

    public void saveAccount(Account account){
        accountRepository.save(account);
    }

    public void deleteAccount(Account account){
        accountRepository.delete(account);
    }
}
