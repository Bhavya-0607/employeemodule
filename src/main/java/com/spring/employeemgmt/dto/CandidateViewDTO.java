package com.spring.employeemgmt.dto;

import lombok.Data;
import java.util.List;

import com.spring.employeemgmt.entity.CandidateView.CandidateViewBuilder;

@Data
public class CandidateViewDTO {
    private String viewName;
    private List<String> selectedColumns;
    public static CandidateViewBuilder builder() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'builder'");
    }
}
