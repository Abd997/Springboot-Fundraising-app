package com.example.fundraisingapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
public class FundSeeker {
    
    @Id
    @Column
    private int id;
    
    @Column
    private String username;
    
    @Column(unique = true)
    private String email;
    
    @Column
    private String password;
    
    @Column
    private String location;
    
    @Column
    private String purpose;
    
    @Column
    private int targetAmount;
    
    @Column
    private String targetDate;
    
    @Column(unique = true)
    private int bankCard;
    
    public FundSeeker() {
    
    }
}
