package com.spring.employeemgmt.entity;

import java.time.LocalDateTime;
import java.util.List;

import javax.print.DocFlavor.STRING;

import jakarta.persistence.*;

import com.spring.employeemgmt.enums.Department;
import com.spring.employeemgmt.enums.ViewPermissionType;
import com.spring.employeemgmt.entity.Role;
import com.spring.employeemgmt.entity.Candidate; // Replace with Candidate if no User entity

@Entity
@Table(name = "view_config")
public class ViewConfig<Location> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String viewName;

    @Enumerated(EnumType.STRING)
    private ViewPermissionType permission;

    private boolean defaultView;

    @ElementCollection
    @CollectionTable(name = "view_columns", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "column_name")
    private List<String> selectedColumns;

    // Replace 'User' with 'Candidate' if needed
    @ManyToMany
    @JoinTable(name = "view_shared_users",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<Candidate> sharedToUsers;

    // Department is an enum, not an entity
    @ElementCollection
    @CollectionTable(name = "view_shared_departments", joinColumns = @JoinColumn(name = "view_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "department")
    private List<Department> sharedToDepartments;

    @ManyToMany
    @JoinTable(name = "view_shared_roles",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> sharedToRoles;

    @ElementCollection
    @CollectionTable(name = "view_shared_locations", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "location_name")
    private List<String> sharedToLocations;

    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    // Getters and setters (optional)
    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }
}
