package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.entity.Candidate;
import com.spring.employeemgmt.enums.AttendanceStatus;
import com.spring.employeemgmt.repository.AttendanceRepository;
import com.spring.employeemgmt.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @Autowired
    private CandidateRepository candidateRepository;

    // Fetch all attendance records
    public List<Attendance> getAllAttendancesRecords() {
        return attendanceRepository.findAll();
    }

    // Get attendance by ID
    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    // Create new attendance
    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    // Update existing attendance
    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance existing = attendanceRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setCheckInTime(updatedAttendance.getCheckInTime());
            existing.setCheckOutTime(updatedAttendance.getCheckOutTime());
            existing.setStatus(updatedAttendance.getStatus());
            existing.setTotalHoursWorked(updatedAttendance.getTotalHoursWorked());
            return attendanceRepository.save(existing);
        }
        return null;
    }

    // Delete attendance record by ID
    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }

    // Check-In logic
    public Attendance checkIn(Long userId) {
        Candidate candidate = candidateRepository.findById(userId).orElse(null);
        if (candidate == null) {
            return null;
        }

        Attendance attendance = new Attendance();
        attendance.setCandidate(candidate);
        attendance.setCheckInTime(LocalDateTime.now());
        attendance.setStatus(AttendanceStatus.PRESENT);
        return attendanceRepository.save(attendance);
    }

    // Check-Out logic
    public Attendance checkOut(Long userId) {
        Candidate candidate = candidateRepository.findById(userId).orElse(null);
        if (candidate == null) {
            return null;
        }

        Optional<Attendance> optionalAttendance =
                attendanceRepository.findTopByUserOrderByCheckInTimeDesc(candidate);

        if (optionalAttendance.isPresent()) {
            Attendance attendance = optionalAttendance.get();
            if (attendance.getCheckOutTime() == null) {
                attendance.setCheckOutTime(LocalDateTime.now());

                // This method should calculate the duration between check-in and check-out
                attendance.calculateTotalHoursWorked();

                return attendanceRepository.save(attendance);
            }
        }

        return null; // Already checked out or not found
    }
}
