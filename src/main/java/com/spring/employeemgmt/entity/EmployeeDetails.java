package com.spring.employeemgmt.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private Candidate user;

    private String department;
    private String designation;
    private Double salary;
    private String manager;
    public Object getDepartment() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDepartment'");
    }
    public void setDepartment(Object department2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setDepartment'");
    }
    public Object getDesignation() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getDesignation'");
    }
    public void setDesignation(Object designation2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setDesignation'");
    }
    public Object getSalary() {

        throw new UnsupportedOperationException("Unimplemented method 'getSalary'");
    }
    public void setSalary(Object salary2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setSalary'");
    }
    public Object getJoiningDate() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getJoiningDate'");
    }
    public void setJoiningDate(Object joiningDate) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setJoiningDate'");
    }
    public Object getEmploymentType() {
        
        throw new UnsupportedOperationException("Unimplemented method 'getEmploymentType'");
    }
    public void setEmploymentType(Object employmentType) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setEmploymentType'");
    }

    
}
