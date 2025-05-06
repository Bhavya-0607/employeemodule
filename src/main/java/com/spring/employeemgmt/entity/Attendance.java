package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.spring.employeemgmt.enums.AttendanceStatus;

@Entity
@Table(name = "attendance")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Candidate user;

    @Column(name = "check_in_time")
    private LocalDateTime checkInTime;

    @Column(name = "check_out_time")
    private LocalDateTime checkOutTime;

    @Enumerated(EnumType.STRING)
    private AttendanceStatus status;

    private Double totalHoursWorked;

    // Derived date from check-in (optional convenience method)
    public LocalDate getDate() {
        return (checkInTime != null) ? checkInTime.toLocalDate() : null;
    }
  

    public LocalDateTime getCheckInTime() { return checkInTime; }
    public void setCheckInTime(LocalDateTime checkInTime) { this.checkInTime = checkInTime; }


    // Convenience method to auto-calculate total hours
    public void calculateTotalHoursWorked() {
        if (checkInTime != null && checkOutTime != null) {
            Duration duration = Duration.between(checkInTime, checkOutTime);
            this.totalHoursWorked = duration.toMinutes() / 60.0;
        } else {
            this.totalHoursWorked = 0.0;
        }
    }
}
