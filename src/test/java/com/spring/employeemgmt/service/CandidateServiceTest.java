package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Candidate;
import com.spring.employeemgmt.repository.CandidateRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CandidateServiceTest {

    @Mock
    private CandidateRepository candidateRepository;

    @InjectMocks
    private CandidateService candidateService;

    private Candidate sampleCandidate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        sampleCandidate = new Candidate();
        sampleCandidate.setFirstName("John Doe");
        sampleCandidate.setEmailId("john@example.com");
    }

    @Test
    public void testCreateCandidate() {
        when(candidateRepository.save(any(Candidate.class))).thenReturn(sampleCandidate);
        Candidate created = candidateService.createCandidate(sampleCandidate);
        assertNotNull(created);
        assertEquals("John Doe", created.getFirstName());
        assertEquals("john@example.com", created.getEmailId());
    }

    @Test
    public void testGetAllCandidates() {
        when(candidateRepository.findAll()).thenReturn(Arrays.asList(sampleCandidate));
        List<Candidate> candidates = candidateService.getAllCandidates();
        assertEquals(1, candidates.size());
        assertEquals("John Doe", candidates.get(0).getFirstName());
    }

    @Test
    public void testGetCandidateById() {
        when(candidateRepository.findById(1L)).thenReturn(Optional.of(sampleCandidate));
        Candidate found = candidateService.getCandidateById(1L);
        assertNotNull(found);
        assertEquals("john@example.com", found.getEmailId());
    }

    @Test
    public void testUpdateCandidate() {
        Candidate updatedCandidate = new Candidate();
        updatedCandidate.setFirstName("Jane Doe");
        updatedCandidate.setEmailId("jane@example.com");

        when(candidateRepository.findById(1L)).thenReturn(Optional.of(sampleCandidate));
        when(candidateRepository.save(any(Candidate.class))).thenReturn(updatedCandidate);

        Candidate result = candidateService.updateCandidate(1L, updatedCandidate);
        assertNotNull(result);
        assertEquals("Jane Doe", result.getFirstName());
        assertEquals("jane@example.com", result.getEmailId());
    }

    @Test
    public void testDeleteCandidate() {
        doNothing().when(candidateRepository).deleteById(1L);
        candidateService.deleteCandidate(1L);
        verify(candidateRepository, times(1)).deleteById(1L);
    }
}
