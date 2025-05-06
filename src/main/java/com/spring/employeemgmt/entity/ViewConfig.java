package com.spring.employeemgmt.entity;

import java.time.LocalDateTime;
import java.util.List;
import javax.tools.DocumentationTool.Location;
import org.apache.catalina.User;
import com.spring.employeemgmt.enums.Department;
import jakarta.persistence.*;

@Entity
@Table(name = "view_config")
public class ViewConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String viewName;

    @Enumerated(EnumType.STRING)
    private ViewPermission permission;

    private boolean defaultView;

    @ElementCollection
    @CollectionTable(name = "view_columns", joinColumns = @JoinColumn(name = "view_id"))
    @Column(name = "column_name")
    private List<String> selectedColumns;

    @ManyToMany
    @JoinTable(name = "view_shared_users",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> sharedToUsers;

    @ManyToMany
    @JoinTable(name = "view_shared_departments",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "department_id"))
    private List<Department> sharedToDepartments;

    @ManyToMany
    @JoinTable(name = "view_shared_roles",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> sharedToRoles;

    @ManyToMany
    @JoinTable(name = "view_shared_locations",
            joinColumns = @JoinColumn(name = "view_id"),
            inverseJoinColumns = @JoinColumn(name = "location_id"))
    private List<Location> sharedToLocations;

    // Auditing fields
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    public void setCreatedAt(LocalDateTime now) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setCreatedAt'");
    }

    // createdBy, modifiedBy can be added if you track users
}
