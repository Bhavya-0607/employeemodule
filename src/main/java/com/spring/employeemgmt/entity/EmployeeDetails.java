package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "employee_details")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id", referencedColumnName = "candidateId")
    private Candidate candidate;

    private String department;
    private String designation;
    private Double salary;
    private String manager;

    private LocalDate joiningDate;
    private String employmentType; // e.g., "Full-Time", "Intern", etc.
}
