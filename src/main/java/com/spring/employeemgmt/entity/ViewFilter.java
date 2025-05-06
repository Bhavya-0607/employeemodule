package com.spring.employeemgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "view_filters")
public class ViewFilter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fieldName;

    @Enumerated(EnumType.STRING)
    private FilterOperator operator; // EQUALS, CONTAINS, GREATER_THAN, etc.

    private String value;

    @ManyToOne
    @JoinColumn(name = "view_id")
    private CandidateView candidateView;
}
