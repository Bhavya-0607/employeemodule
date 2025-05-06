package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.spring.employeemgmt.enums.Country;
import com.spring.employeemgmt.enums.Department;
import com.spring.employeemgmt.enums.HighestQualification;
import com.spring.employeemgmt.enums.OnboardingStatus;
import com.spring.employeemgmt.enums.SourceOfHire;
import com.spring.employeemgmt.enums.State;
import com.spring.employeemgmt.enums.Title;

@Entity
@Table(name = "candidates")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long candidateId;

    private String firstName;
    private String lastName;
    private String emailId;
    private String officialEmail;
    private Long id;


    private String phone;
    @Lob
    private byte[] photo;

    @Enumerated(EnumType.STRING)
    private OnboardingStatus onboardingStatus;

    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private SourceOfHire sourceOfHire;

    private String panCardNumber;
    private String aadhaarCardNumber;
    private String uanNumber;

    // Present Address
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private State state;

    @Enumerated(EnumType.STRING)
    private Country country;

    private String permanentAddress;

    private LocalDate tentativeJoiningDate;

    private String offerLetter;

    @Lob
    private String additionalInformation;

    private Double currentSalary;
    private Integer experience; // In years

    @Enumerated(EnumType.STRING)
    private Title title;

    @Enumerated(EnumType.STRING)
    private HighestQualification highestQualification;

    private String skillSet; // comma-separated or use @ElementCollection

    private String addedBy;
    private String modifiedBy;

    private LocalDateTime addedTime;
    private LocalDateTime modifiedTime;

    private String designation;
    private String workSchedule; // Example: 9:00 AM - 6:00 PM

    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Attendance> attendances = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<ProjectAssignment> projectAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<TimeLog> timeLogs = new ArrayList<>();

    public void setId(Long id) {
        this.id = id;
    }
    
    
}

