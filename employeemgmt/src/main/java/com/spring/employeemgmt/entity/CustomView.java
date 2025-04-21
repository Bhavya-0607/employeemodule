package com.spring.employeemgmt.entity;

import jakarta.persistence.Entity;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.security.core.userdetails.User;

import jakarta.persistence.*;

@Entity
@Table(name = "custom_views")
public class CustomView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String viewName;

    private boolean isDefault;

    @Enumerated(EnumType.STRING)
    private ViewPermission viewPermission;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "custom_view_columns", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "column_name")
    private List<String> selectedColumns;

    // Sharing logic: if shared with specific departments/roles/users/locations
    @ElementCollection
    @CollectionTable(name = "custom_view_shared_departments", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedDepartments;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_roles", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedRoles;

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_users", joinColumns = @JoinColumn(name = "view_id"))
    private List<Long> sharedUserIds; // userId of users shared with

    @ElementCollection
    @CollectionTable(name = "custom_view_shared_locations", joinColumns = @JoinColumn(name = "view_id"))
    private List<String> sharedLocations;

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    private LocalDateTime createdTime;

    @ManyToOne
    @JoinColumn(name = "modified_by")
    private User modifiedBy;

    private LocalDateTime modifiedTime;
}
