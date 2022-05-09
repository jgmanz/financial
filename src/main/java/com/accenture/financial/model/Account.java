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
public class Account {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @ManyToOne
    @JoinColumn(name = "client_id") 
    private Client client;
    @Column
    private LocalDate openDate;
    

    public Account() {
    }

    public Account(Long id, Client client, LocalDate openDate) {
        this.id = id;
        this.client = client;
        this.openDate = openDate;
    }
    
    public Account(Client client, LocalDate openDate) {
        this.client = client;
        this.openDate = openDate;
    }

    public Long getId() {
        return id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public LocalDate getOpenDate() {
        return openDate;
    }

    public void setOpenDate(LocalDate openDate) {
        this.openDate = openDate;
    }
}
