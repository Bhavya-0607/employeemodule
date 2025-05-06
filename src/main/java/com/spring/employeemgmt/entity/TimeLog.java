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
public class TimeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Candidate user;

    @Column(name = "log_time")
    private LocalDateTime logTime;

    @Column(name = "description")
    private String description;

    // ✅ Added missing fields
    @Column(name = "check_in")
    private LocalDateTime checkIn;

    @Column(name = "check_out")
    private LocalDateTime checkOut;

    @Column(name = "remarks")
    private String remarks;

    public TimeLog(Candidate user, LocalDateTime logTime, String description) {
        this.user = user;
        this.logTime = logTime;
        this.description = description;
    }

    // Optionally remove these if using Lombok's @Getter
    public LocalDateTime getCheckIn() {
        return checkIn;
    }

    public LocalDateTime getCheckOut() {
        return checkOut;
    }

    public String getRemarks() {
        return remarks;
    }
}
