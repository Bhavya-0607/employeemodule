package com.spring.employeemgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "payroll")
public class PayRoll {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate user;

    private Double baseSalary;
    private Double bonus;
    private Double deductions;
    private Double netSalary;

    // Getters and Setters
}
