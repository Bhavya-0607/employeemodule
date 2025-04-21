
package com.spring.employeemgmt.service;

import com.spring.employeemgmt.dto.CandidateViewDTO;
import com.spring.employeemgmt.dto.CandidateViewRequest;
import com.spring.employeemgmt.entity.CandidateView;
import com.spring.employeemgmt.repository.CandidateViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateViewService {

    @Autowired
    private CandidateViewRepository viewRepository;

    public CandidateView saveView(CandidateViewDTO dto, String createdBy) {
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

    public CandidateView saveView(CandidateView view) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveView'");
    }

    public Object getViewsForUser(String username) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getViewsForUser'");
    }

    public Object getViewsByUser(String userId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getViewsByUser'");
    }

    public CandidateView getViewById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getViewById'");
    }

    public void deleteView(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteView'");
    }
}
