
package com.spring.employeemgmt.dto;

import lombok.Data;

@Data
public class CandidateViewCriteriaRequest {
    private String field;
    private String operator;
    private String value;
}
