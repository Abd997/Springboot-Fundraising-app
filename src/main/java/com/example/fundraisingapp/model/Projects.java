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
public class Projects {
    
    @Id
    @Column
    private int id;
    
    @Column
    private String title;
    
    @Column
    private int fundsRequired;
    
    @Column
    private int fundsGiven;
    
    public Projects() {
    
    }
}