package com.spring.employeemgmt.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "candidate_view_criteria")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateViewCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String field; // Example: "firstName", "department"
    private String operator; // Example: "equals", "contains"
    private String value; // Example: "John", "HR"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "view_id")
    private CandidateView candidateView;
}
