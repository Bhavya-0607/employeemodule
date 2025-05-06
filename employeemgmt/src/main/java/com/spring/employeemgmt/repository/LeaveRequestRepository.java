package com.spring.employeemgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employeemgmt.entity.LeaveRequest;

// Removed redundant class definition
@Repository
public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> { }
