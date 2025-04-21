package com.spring.employeemgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate user;

    private String department;
    private String designation;
    private Double salary;
    private String manager;

    // Getters and Setters
}
