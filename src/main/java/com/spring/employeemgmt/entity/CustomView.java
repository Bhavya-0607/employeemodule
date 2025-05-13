package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import com.spring.employeemgmt.enums.ViewPermissionType;
import com.spring.employeemgmt.entity.Candidate;

@Entity
@Table(name = "custom_views")
public class CustomView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String viewName;

    private boolean isDefault;

    @Enumerated(EnumType.STRING)
    private ViewPermissionType viewPermission;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "custom_view_columns", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "column_name")
    private List<String> selectedColumns;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_departments", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedDepartments;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_roles", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedRoles;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_users", joinColumns = @JoinColumn(name = "view_id"))
    private List<Long> sharedUserIds;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_locations", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedLocations;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private Candidate createdBy; // your custom User entity

    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private Candidate modifiedBy; // your custom User entity

    private LocalDateTime modifiedTime;

    // Getters and setters...
}
