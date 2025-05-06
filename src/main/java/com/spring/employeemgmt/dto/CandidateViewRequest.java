
package com.spring.employeemgmt.dto;

import com.spring.employeemgmt.enums.ViewPermissionType;
import lombok.Data;
import java.util.List;

@Data
public class CandidateViewRequest {
    private String viewName;
    private String createdBy;
    private Boolean defaultView;
    private ViewPermissionType permissionType;
    private List<String> sharedUserIds;
    private List<String> sharedDepartments;
    private List<String> sharedRoles;
    private List<String> sharedLocations;
    private List<String> selectedColumns;
    private List<CandidateViewCriteriaRequest> criteria;

}
