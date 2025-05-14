package com.spring.employeemgmt.repository;

import com.spring.employeemgmt.entity.TimeLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TimeLogRepository extends JpaRepository<TimeLog, Long> {

    // ✅ Corrected: use 'candidateId' instead of 'userId'
    List<TimeLog> findByCandidateId(Long candidateId);
}
