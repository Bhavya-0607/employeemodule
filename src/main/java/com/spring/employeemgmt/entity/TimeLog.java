package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "time_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private Candidate candidate;

    @Column(name = "log_time", nullable = false)
    private LocalDateTime logTime;

    @Column(name = "description")
    private String description;

    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @Column(name = "remarks")
    private String remarks;

    public TimeLog(Candidate candidate, LocalDateTime logTime, String description) {
        this.candidate = candidate;
        this.logTime = logTime;
        this.description = description;
    }
}
