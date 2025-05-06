package com.spring.employeemgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.employeemgmt.dto.CandidateViewDTO;
import com.spring.employeemgmt.entity.CandidateView;
import com.spring.employeemgmt.repository.CandidateViewRepository;

@Service
public class CandidateViewService {

    @Autowired CandidateViewRepository viewRepository;

    public CandidateView saveView(CandidateView dto, String createdBy) {
        CandidateView view = CandidateView.builder()
                .viewName(dto.getViewName())
                .selectedColumns(dto.getSelectedColumns())
                .createdBy(createdBy)
                .build();
        return viewRepository.save(view);
    }

    public List<CandidateView> getAllViews() {
        return viewRepository.findAll();
    }

    public CandidateView getViewById(Long id) {
        return viewRepository.findById(id).orElse(null);
    }

    public void deleteView(Long id) {
        viewRepository.deleteById(id);
    }

    public List<CandidateView> getViewsByUser(String userId) {
        return viewRepository.findByCreatedBy(userId);
    }
}
