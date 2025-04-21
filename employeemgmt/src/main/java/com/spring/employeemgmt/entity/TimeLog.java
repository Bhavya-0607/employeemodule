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

    public TimeLog(Candidate user, LocalDateTime logTime, String description) {
        this.user = user;
        this.logTime = logTime;
        this.description = description;
    }
}
