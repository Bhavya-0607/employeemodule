package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.repository.AttendanceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public List<Attendance> getAllAttendances() {
        return attendanceRepository.findAll();
    }

    public Attendance getAttendanceById(Long id) {
        return attendanceRepository.findById(id).orElse(null);
    }

    public Attendance createAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance updatedAttendance) {
        Attendance existing = attendanceRepository.findById(id).orElse(null);
        if (existing != null) {
            existing.setDate(updatedAttendance.getDate());
            existing.setCheckInTime(updatedAttendance.getCheckInTime());
            existing.setCheckOutTime(updatedAttendance.getCheckOutTime());
            existing.setTotalHoursWorked(updatedAttendance.getTotalHoursWorked());
            existing.setStatus(updatedAttendance.getStatus());
            return attendanceRepository.save(existing);
        }
        return null;
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);

        throw new UnsupportedOperationException("Unimplemented method 'getAllAttendanceRecords'");
    }

    public Object checkIn(Long userId) {

        throw new UnsupportedOperationException("Unimplemented method 'checkIn'");
    }

    public Object checkOut(Long userId) {

        throw new UnsupportedOperationException("Unimplemented method 'checkOut'");
    }

    public List<Attendance> getAllAttendanceRecords() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllAttendanceRecords'");
    }
}
