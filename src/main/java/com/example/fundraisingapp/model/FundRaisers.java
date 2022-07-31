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
public class FundRaisers {
    
    @Id
    @Column
    private int id;
    
    @Column(unique = true)
    private String username;
    
    @Column
    private String password;
    
    @Column
    private int money;
    
    public FundRaisers() {
    
    }
}