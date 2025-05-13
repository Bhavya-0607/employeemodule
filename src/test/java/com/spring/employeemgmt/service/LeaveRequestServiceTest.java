package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.LeaveRequest;
import com.spring.employeemgmt.enums.LeaveStatus;
import com.spring.employeemgmt.repository.LeaveRequestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LeaveRequestServiceTest {

    @Mock
    private LeaveRequestRepository leaveRequestRepository;

    @InjectMocks
    private LeaveRequestService leaveRequestService;

    private LeaveRequest leaveRequest;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        leaveRequest = LeaveRequest.builder()
                .id(1L)
                .startDate(LocalDate.of(2025, 4, 25))
                .endDate(LocalDate.of(2025, 4, 27))
                .status(LeaveStatus.PENDING)
                .build();
    }

    @Test
    void testApplyLeave_ValidDates() {
        when(leaveRequestRepository.save(any(LeaveRequest.class))).thenReturn(leaveRequest);

        LeaveRequest savedLeave = leaveRequestService.applyLeave(leaveRequest);

        assertNotNull(savedLeave);
        assertEquals(LocalDate.of(2025, 4, 25), savedLeave.getStartDate());
        assertEquals(LocalDate.of(2025, 4, 27), savedLeave.getEndDate());
        assertEquals(LeaveStatus.PENDING, savedLeave.getStatus());

        verify(leaveRequestRepository, times(1)).save(leaveRequest);
    }

    @Test
    void testApplyLeave_InvalidDates_ShouldThrowException() {
        leaveRequest.setStartDate(LocalDate.of(2025, 4, 28)); // start > end

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            leaveRequestService.applyLeave(leaveRequest);
        });

        assertEquals("Start date cannot be after end date.", exception.getMessage());
        verify(leaveRequestRepository, never()).save(any());
    }

    @Test
    void testGetAllLeaves() {
        when(leaveRequestRepository.findAll()).thenReturn(Arrays.asList(leaveRequest));

        List<LeaveRequest> leaves = leaveRequestService.getAllLeaves();

        assertEquals(1, leaves.size());
        assertEquals(1L, leaves.get(0).getId());
        verify(leaveRequestRepository, times(1)).findAll();
    }

    @Test
    void testGetLeaveById_Found() {
        when(leaveRequestRepository.findById(1L)).thenReturn(Optional.of(leaveRequest));

        LeaveRequest found = leaveRequestService.getLeaveById(1L);

        assertNotNull(found);
        assertEquals(1L, found.getId());
        verify(leaveRequestRepository, times(1)).findById(1L);
    }

    @Test
    void testGetLeaveById_NotFound() {
        when(leaveRequestRepository.findById(2L)).thenReturn(Optional.empty());

        LeaveRequest found = leaveRequestService.getLeaveById(2L);

        assertNull(found);
        verify(leaveRequestRepository, times(1)).findById(2L);
    }

    @Test
    void testCancelLeave() {
        doNothing().when(leaveRequestRepository).deleteById(1L);

        leaveRequestService.cancelLeave(1L);

        verify(leaveRequestRepository, times(1)).deleteById(1L);
    }
}
