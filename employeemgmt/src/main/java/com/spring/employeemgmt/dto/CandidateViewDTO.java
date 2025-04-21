package com.spring.employeemgmt.dto;

import lombok.Data;
import java.util.List;

@Data
public class CandidateViewDTO {
    private String viewName;
    private List<String> selectedColumns;
}
