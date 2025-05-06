package com.spring.employeemgmt.repository;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.entity.Candidate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<Attendance> findTopByUserIdOrderByDateDesc(Long userId);
    Optional<Attendance> findTopByUserOrderByCheckInTimeDesc(Candidate user);


    Attendance findTopByUserIdOrderByDateDesc(Candidate user);
}
