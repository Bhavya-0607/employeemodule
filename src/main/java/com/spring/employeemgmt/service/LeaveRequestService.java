package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.LeaveRequest;
import com.spring.employeemgmt.enums.LeaveStatus;
import com.spring.employeemgmt.repository.LeaveRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveRequestService {

    @Autowired
    private LeaveRequestRepository leaveRequestRepository;

    public LeaveRequest applyLeave(LeaveRequest leaveRequest) {
        // Validation: Start date must be before or equal to end date
        if (leaveRequest.getStartDate().isAfter(leaveRequest.getEndDate())) {
            throw new IllegalArgumentException("Start date cannot be after end date.");
        }

        // Set default leave status to PENDING
        leaveRequest.setStatus(LeaveStatus.PENDING);

        return leaveRequestRepository.save(leaveRequest);
    }

    public List<LeaveRequest> getAllLeaves() {
        return leaveRequestRepository.findAll();
    }

    public LeaveRequest getLeaveById(Long id) {
        return leaveRequestRepository.findById(id).orElse(null);
    }

    public void cancelLeave(Long id) {
        leaveRequestRepository.deleteById(id);
    }
}
