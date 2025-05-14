package com.spring.employeemgmt.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.spring.employeemgmt.enums.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    // ✅ Add getter and setter for 'id' to satisfy Spring Data
    public Long getId() {
        return candidateId;
    }

    public void setId(Long id) {
        this.candidateId = id;
    }

    private String firstName;
    private String lastName;

    @Email
    private String emailId;

    @Email
    private String officialEmail;

    @Size(min = 10, max = 10)
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
    private Integer experience;

    @Enumerated(EnumType.STRING)
    private Title title;

    @Enumerated(EnumType.STRING)
    private HighestQualification highestQualification;

    private String skillSet;

    private String addedBy;
    private String modifiedBy;
    private LocalDateTime addedTime;
    private LocalDateTime modifiedTime;

    private String designation;
    private String workSchedule;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToOne(mappedBy = "candidate", cascade = CascadeType.ALL)
    private EmployeeDetails employeeDetails;

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    @ToString.Exclude
    private List<Attendance> attendances = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    @ToString.Exclude
    private List<LeaveRequest> leaveRequests = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    @ToString.Exclude
    private List<ProjectAssignment> projectAssignments = new ArrayList<>();

    @OneToMany(mappedBy = "candidate", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    @JsonIgnore
    @ToString.Exclude
    private List<TimeLog> timeLogs = new ArrayList<>();
}
