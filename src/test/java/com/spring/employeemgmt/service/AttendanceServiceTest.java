package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Attendance;
import com.spring.employeemgmt.entity.Candidate;
import com.spring.employeemgmt.enums.AttendanceStatus;
import com.spring.employeemgmt.repository.AttendanceRepository;
import com.spring.employeemgmt.repository.CandidateRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AttendanceServiceTest {

    @InjectMocks
    private AttendanceService attendanceService; 

    @Mock
    private AttendanceRepository attendanceRepository;

    @Mock
    private CandidateRepository candidateRepository;

    private Attendance attendance;
    private Candidate candidate;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        candidate = new Candidate();
        candidate.setCandidateId(1L);

        attendance = new Attendance();
        attendance.setId(1L);
        attendance.setCandidate(candidate);
        attendance.setCheckInTime(LocalDateTime.of(2023, 1, 1, 9, 0));
        attendance.setCheckOutTime(null);
        attendance.setTotalHoursWorked(0.0);
        attendance.setStatus(AttendanceStatus.PRESENT);
    }

    @Test
    void testCreateAttendance() {
        when(attendanceRepository.save(any(Attendance.class))).thenReturn(attendance);

        Attendance result = attendanceService.createAttendance(attendance);
        assertNotNull(result);
        assertEquals(AttendanceStatus.PRESENT, result.getStatus());
        verify(attendanceRepository, times(1)).save(attendance);
    }

    @Test
    void testGetAttendanceById() {
        when(attendanceRepository.findById(1L)).thenReturn(Optional.of(attendance));

        Attendance result = attendanceService.getAttendanceById(1L);
        assertNotNull(result);
        assertEquals(1L, result.getId());
    }

    @Test
    void testCheckInSuccess() {
        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));
        when(attendanceRepository.save(any(Attendance.class))).thenAnswer(i -> i.getArgument(0));

        Attendance result = attendanceService.checkIn(1L);
        assertNotNull(result);
        assertEquals(AttendanceStatus.PRESENT, result.getStatus());
        assertEquals(candidate, result.getCandidate());
    }

    @Test
    void testCheckOutSuccess() {
        when(candidateRepository.findById(1L)).thenReturn(Optional.of(candidate));
        when(attendanceRepository.findTopByUserOrderByCheckInTimeDesc(candidate)).thenReturn(Optional.of(attendance));
        when(attendanceRepository.save(any(Attendance.class))).thenAnswer(i -> i.getArgument(0));

        Attendance result = attendanceService.checkOut(1L);
        assertNotNull(result);
        assertNotNull(result.getCheckOutTime());
    }
}
