package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.TimeLog;
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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        // Initializing test data
        timeLog = new TimeLog();
        timeLog.setId(1L);
        timeLog.setUser(null);  // Assuming Candidate is not set for now
        timeLog.setLogTime(LocalDateTime.now());
        timeLog.setDescription("Test log");

        updatedTimeLog = new TimeLog();
        updatedTimeLog.setId(1L);
        updatedTimeLog.setUser(null);  // Assuming Candidate is not set for now
        updatedTimeLog.setCheckIn(LocalDateTime.now().minusHours(1));
        updatedTimeLog.setCheckOut(LocalDateTime.now());
        updatedTimeLog.setRemarks("Updated remarks");
    }

    @Test
    public void testGetAllTimeLogs() {
        // Mocking the repository's behavior
        when(timeLogRepository.findAll()).thenReturn(List.of(timeLog));

        // Testing the method
        var timeLogs = timeLogService.getAllTimeLogs();

        // Verifying interactions
        assertNotNull(timeLogs);
        assertEquals(1, timeLogs.size());
        verify(timeLogRepository, times(1)).findAll();
    }

    @Test
    public void testGetTimeLogById() {
        // Mocking the repository's behavior
        when(timeLogRepository.findById(any(Long.class))).thenReturn(Optional.of(timeLog));

        // Testing the method
        var result = timeLogService.getTimeLogById(1L);

        // Verifying the result
        assertNotNull(result);
        assertEquals(1L, result.getId());
        verify(timeLogRepository, times(1)).findById(1L);
    }

    @Test
    public void testCreateTimeLog() {
        // Mocking the repository's behavior
        when(timeLogRepository.save(any(TimeLog.class))).thenReturn(timeLog);

        // Testing the method
        var createdTimeLog = timeLogService.createTimeLog(timeLog);

        // Verifying the result
        assertNotNull(createdTimeLog);
        assertEquals("Test log", createdTimeLog.getDescription());
        verify(timeLogRepository, times(1)).save(any(TimeLog.class));
    }

    @Test
    public void testUpdateTimeLog() {
        // Mocking repository's behavior for retrieving an existing TimeLog
        when(timeLogRepository.findById(any(Long.class))).thenReturn(Optional.of(timeLog));
        // Mocking repository's behavior for saving updated TimeLog
        when(timeLogRepository.save(any(TimeLog.class))).thenReturn(updatedTimeLog);

        // Testing the update method
        var updated = timeLogService.updateTimeLog(1L, updatedTimeLog);

        // Verifying the result
        assertNotNull(updated);
        assertEquals(updatedTimeLog.getCheckIn(), updated.getCheckIn());
        assertEquals(updatedTimeLog.getCheckOut(), updated.getCheckOut());
        assertEquals(updatedTimeLog.getRemarks(), updated.getRemarks());
        verify(timeLogRepository, times(1)).findById(1L);
        verify(timeLogRepository, times(1)).save(any(TimeLog.class));
    }

    @Test
    public void testDeleteTimeLog() {
        // Mocking repository's behavior
        when(timeLogRepository.existsById(any(Long.class))).thenReturn(true);

        // Testing the delete method
        timeLogService.deleteTimeLog(1L);

        // Verifying the result
        verify(timeLogRepository, times(1)).deleteById(1L);
    }

    @Test
    public void testDeleteTimeLog_NotFound() {
        // Mocking repository's behavior to return false for non-existent TimeLog
        when(timeLogRepository.existsById(any(Long.class))).thenReturn(false);

        // Testing the delete method with exception
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            timeLogService.deleteTimeLog(1L);
        });

        // Verifying the exception message
        assertEquals("TimeLog not found with id: 1", exception.getMessage());
    }
}

