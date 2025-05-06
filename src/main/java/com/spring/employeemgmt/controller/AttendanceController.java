package com.spring.employeemgmt.controller;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @GetMapping
    public List<Attendance> getAllAttendanceRecords() {
        return attendanceService.getAllAttendancesRecords();
    }

    @PostMapping("/check-in/{userId}")
    public ResponseEntity<Object> checkIn(@PathVariable Long userId) {
        return ResponseEntity.ok(attendanceService.checkIn(userId));
    }

    @PostMapping("/check-out/{userId}")
    public ResponseEntity<Object> checkOut(@PathVariable Long userId) {
        return ResponseEntity.ok(attendanceService.checkOut(userId));
    }
}
