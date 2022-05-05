package com.accenture.financial.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;  
 
@Entity
@Table
public class Client {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;
    @Column
    private String name;
    @Column
    private LocalDate dateOfBirth; 
    @Column
    private LocalDate accountOpenDate; 
    @Column
    private String telephone;
    


    public Client() {
    }

    public Client(Long id, String name, LocalDate dateOfBirth, String telephone) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
    }


    public Client(String name, LocalDate dateOfBirth, String telephone) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.telephone = telephone;
    }

    

}
