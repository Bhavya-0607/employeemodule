
package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name = "candidate_view")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String viewName;

    private String createdBy;
    private Boolean defaultView;
    private String modifiedBy;

    private String field; // e.g., "firstName", "department"
    private String operator; // e.g., "equals", "contains"
    private String value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "view_id")
    private CandidateView candidateView;

    @Enumerated(EnumType.STRING)
    private ViewPermissionType permissionType;

    @ElementCollection
    @CollectionTable(name = "candidate_view_shared_users", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "user_id")
    private List<String> sharedUserIds;

    @ElementCollection
    @CollectionTable(name = "candidate_view_shared_departments", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "department")
    private List<String> sharedDepartments;

    @ElementCollection
    @CollectionTable(name = "candidate_view_shared_roles", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "role")
    private List<String> sharedRoles;

    @ElementCollection
    @CollectionTable(name = "candidate_view_shared_locations", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "location")
    private List<String> sharedLocations;

    @ElementCollection
    @CollectionTable(name = "candidate_view_columns", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "column_name")
    private List<String> selectedColumns;

    @OneToMany(mappedBy = "candidateView", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CandidateViewCriteria> criteria;

}
