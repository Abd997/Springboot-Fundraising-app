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
public class FundContributor {
    
    @Id
    @Column
    private int id;
    
    @Column(unique = true)
    private String username;
    
    @Column(unique = true)
    private String email;
    
    @Column
    private String password;
    
    @Column
    private int bankCard;
    
    @Column
    private int money;
    
    public FundContributor() {
    
    }
}