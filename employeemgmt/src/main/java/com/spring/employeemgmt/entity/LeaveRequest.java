package com.spring.employeemgmt.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "leave_requests")
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate user;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private LeaveStatus status; // PENDING, APPROVED, REJECTED

    // Getters and Setters
}
