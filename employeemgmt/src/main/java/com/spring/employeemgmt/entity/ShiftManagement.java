package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "shift_management")
public class ShiftManagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Candidate user;

    private LocalTime shiftStart;
    private LocalTime shiftEnd;
    private boolean isNightShift;

    // Getters and Setters
}
