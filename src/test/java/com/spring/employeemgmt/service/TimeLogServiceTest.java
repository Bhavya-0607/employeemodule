package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.TimeLog;
import com.spring.employeemgmt.entity.Candidate;
import com.spring.employeemgmt.repository.TimeLogRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class TimeLogServiceTest {

    @Mock
    private TimeLogRepository timeLogRepository;

    @InjectMocks
    private TimeLogService timeLogService;

    private TimeLog timeLog;
    private TimeLog updatedTimeLog;
    private Candidate candidate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        candidate = new Candidate();
        candidate.setCandidateId(100L);
        candidate.setFirstName("John");

        timeLog = new TimeLog();
        timeLog.setId(1L);
        timeLog.setCandidate(candidate);
        timeLog.setLogTime(LocalDateTime.now());
        timeLog.setDescription("Test log");

        updatedTimeLog = new TimeLog();
        updatedTimeLog.setId(1L);
        updatedTimeLog.setCandidate(candidate);
        updatedTimeLog.setCheckIn(LocalDateTime.now().minusHours(1));
        updatedTimeLog.setCheckOut(LocalDateTime.now());
        updatedTimeLog.setRemarks("Updated remarks");
        updatedTimeLog.setLogTime(LocalDateTime.now());
        updatedTimeLog.setDescription("Updated log");
    }

    @Test
    public void testGetAllTimeLogs() {
        when(timeLogRepository.findAll()).thenReturn(List.of(timeLog));

        List<TimeLog> timeLogs = timeLogService.getAllTimeLogs();

        assertNotNull(timeLogs);
        assertEquals(1, timeLogs.size());
        verify(timeLogRepository, times(1)).findAll();
    }

    @Test
    public void testGetTimeLogById() {
        when(timeLogRepository.findById(any(Long.class))).thenReturn(Optional.of(timeLog));

        TimeLog result = timeLogService.getTimeLogById(1L);

        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(timeLogRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateTimeLog() {
        when(timeLogRepository.save(any(TimeLog.class))).thenReturn(timeLog);

        TimeLog created = timeLogService.createTimeLog(timeLog);

        assertNotNull(created);
        assertEquals("Test log", created.getDescription());
        verify(timeLogRepository, times(1)).save(any(TimeLog.class));
    }

    @Test
    public void testUpdateTimeLog() {
        when(timeLogRepository.findById(any(Long.class))).thenReturn(Optional.of(timeLog));
        when(timeLogRepository.save(any(TimeLog.class))).thenReturn(updatedTimeLog);

        TimeLog updated = timeLogService.updateTimeLog(1L, updatedTimeLog);

        assertNotNull(updated);
        assertEquals(updatedTimeLog.getCheckIn(), updated.getCheckIn());
        assertEquals(updatedTimeLog.getCheckOut(), updated.getCheckOut());
        assertEquals(updatedTimeLog.getRemarks(), updated.getRemarks());
        assertEquals(updatedTimeLog.getCandidate(), updated.getCandidate());
        verify(timeLogRepository, times(1)).findById(1L);
        verify(timeLogRepository, times(1)).save(any(TimeLog.class));
    }

    @Test
    public void testDeleteTimeLog() {
        when(timeLogRepository.existsById(any(Long.class))).thenReturn(true);

        timeLogService.deleteTimeLog(1L);

        verify(timeLogRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteTimeLog_NotFound() {
        when(timeLogRepository.existsById(any(Long.class))).thenReturn(false);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            timeLogService.deleteTimeLog(1L);
        });

        assertEquals("TimeLog not found with id: 1", exception.getMessage());
    }

    @Test
    public void testGetTimeLogsByCandidateId() {
        when(timeLogRepository.findByCandidateId(any(Long.class))).thenReturn(List.of(timeLog));

        List<TimeLog> timeLogs = timeLogService.getTimeLogsByCandidateId(100L);

        assertNotNull(timeLogs);
        assertEquals(1, timeLogs.size());
        assertEquals(candidate.getCandidateId(), timeLogs.get(0).getCandidate().getCandidateId());
        verify(timeLogRepository, times(1)).findByCandidateId(100L);
    }
}
