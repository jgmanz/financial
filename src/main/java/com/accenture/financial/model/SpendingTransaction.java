package com.accenture.financial.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table
public class SpendingTransaction {
    
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column
    private LocalDate transactionDate; 
    @Column
    private double amount;
    

    public SpendingTransaction() {
    }


    public SpendingTransaction(Long id, Account account, LocalDate transactionDate, double amount) {
        this.id = id;
        this.account = account;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }

    public SpendingTransaction(Account account, LocalDate transactionDate, double amount) {
        this.account = account;
        this.transactionDate = transactionDate;
        this.amount = amount;
    }


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getTransactionDate() {
        return this.transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }


    
}
