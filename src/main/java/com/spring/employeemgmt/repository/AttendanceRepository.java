package com.spring.employeemgmt.repository;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {

    // Find top attendance by candidate_id, ordered by check-in time
    Optional<Attendance> findTopByCandidate_CandidateIdOrderByCheckInTimeDesc(Long candidateId);

    // Find top attendance for a specific candidate, ordered by check-in time
    Optional<Attendance> findTopByCandidateOrderByCheckInTimeDesc(Candidate candidate);

    // Find the last attendance record for a specific candidate (using check-in date)
    Attendance findTopByCandidate_CandidateIdOrderByCheckInTimeDesc(Candidate candidate);
}
