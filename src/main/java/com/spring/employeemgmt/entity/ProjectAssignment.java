package com.spring.employeemgmt.entity;
import jakarta.persistence.*;
    
@Entity
@Table(name = "project_assignment")
public class ProjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id") // foreign key
    private Candidate candidate;

}

        
    
    

