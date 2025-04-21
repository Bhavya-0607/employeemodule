package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Candidate;
import java.util.List;

public interface CandidateService {
    Candidate createCandidate(Candidate candidate);

    List<Candidate> getAllCandidates();

    Candidate getCandidateById(Long id);

    Candidate updateCandidate(Long id, Candidate candidate);

    void deleteCandidate(Long id);

    Candidate createUser(Candidate user);
}
