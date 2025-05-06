package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.TimeLog;
import com.spring.employeemgmt.repository.TimeLogRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeLogService {

    private final TimeLogRepository timeLogRepository;

    // Constructor injection
    public TimeLogService(TimeLogRepository timeLogRepository) {
        this.timeLogRepository = timeLogRepository;
    }

    // Retrieve all TimeLogs
    public List<TimeLog> getAllTimeLogs() {
        return timeLogRepository.findAll();
    }

    // Retrieve a specific TimeLog by its ID
    public TimeLog getTimeLogById(Long id) {
        return timeLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeLog not found with id: " + id));
    }

    // Create a new TimeLog entry
    public TimeLog createTimeLog(TimeLog timeLog) {
        return timeLogRepository.save(timeLog);
    }

    // Update an existing TimeLog entry
    public TimeLog updateTimeLog(Long id, TimeLog timeLog) {
        TimeLog existingTimeLog = timeLogRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TimeLog not found with id: " + id));

        // Updating the TimeLog fields based on the provided object
        existingTimeLog.setCheckIn(timeLog.getCheckIn());
        existingTimeLog.setCheckOut(timeLog.getCheckOut());
        existingTimeLog.setRemarks(timeLog.getRemarks());
        existingTimeLog.setUser(timeLog.getUser());  // Assuming user relation exists

        // Save the updated TimeLog
        return timeLogRepository.save(existingTimeLog);
    }

    // Delete a TimeLog entry by its ID
    public void deleteTimeLog(Long id) {
        if (!timeLogRepository.existsById(id)) {
            throw new RuntimeException("TimeLog not found with id: " + id);
        }
        timeLogRepository.deleteById(id);
    }
}

