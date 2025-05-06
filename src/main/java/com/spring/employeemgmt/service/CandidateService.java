package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.Candidate;
import com.spring.employeemgmt.repository.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    // Create a new Candidate
    public Candidate createCandidate(Candidate candidate) {
        return candidateRepository.save(candidate);
    }

    // Get all Candidates
    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    // Get Candidate by ID
    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElse(null);
    }

    // Update Candidate
    public Candidate updateCandidate(Long id, Candidate updatedCandidate) {
        return candidateRepository.findById(id).map(existing -> {
            existing.setFirstName(updatedCandidate.getFirstName());
            existing.setEmailId(updatedCandidate.getEmailId());
            existing.setPhone(updatedCandidate.getPhone());
            existing.setAddedTime(updatedCandidate.getAddedTime());
            existing.setDepartment(updatedCandidate.getDepartment());
            existing.setOnboardingStatus(updatedCandidate.getOnboardingStatus());
            existing.setSourceOfHire(updatedCandidate.getSourceOfHire());
            existing.setHighestQualification(updatedCandidate.getHighestQualification());
            existing.setPanCardNumber(updatedCandidate.getPanCardNumber());
            existing.setAadhaarCardNumber(updatedCandidate.getAadhaarCardNumber());
            existing.setUanNumber(updatedCandidate.getUanNumber());
            existing.setSkillSet(updatedCandidate.getSkillSet());
            existing.setPhoto(updatedCandidate.getPhoto());
            return candidateRepository.save(existing);
        }).orElse(null);
    }

    // Delete Candidate
    public void deleteCandidate(Long id) {
        candidateRepository.deleteById(id);
    }
}
