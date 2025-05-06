
package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.EmployeeDetails;
import com.spring.employeemgmt.repository.EmployeeDetailsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeDetailsService {

    @Autowired
    private EmployeeDetailsRepository repository;

    // Save or update employee details
    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {
        return repository.save(employeeDetails);
    }

    // Get employee details by ID
    public EmployeeDetails getEmployeeDetailsById(Long id) {
        return repository.findById(id).orElse(null);
    }

    // Get all employee records
    public List<EmployeeDetails> getAllEmployeeDetails() {
        return repository.findAll();
    }

    // Update existing employee details
    public EmployeeDetails updateEmployeeDetails(Long id, EmployeeDetails updatedDetails) {
        Optional<EmployeeDetails> optional = repository.findById(id);
        if (optional.isPresent()) {
            EmployeeDetails existing = optional.get();
            existing.setDepartment(updatedDetails.getDepartment());
            existing.setDesignation(updatedDetails.getDesignation());
            existing.setSalary(updatedDetails.getSalary());
            existing.setJoiningDate(updatedDetails.getJoiningDate());
            existing.setEmploymentType(updatedDetails.getEmploymentType());
            // Add more fields as necessary
            return repository.save(existing);
        }
        return null;
    }

    // Delete employee record by ID
    public void deleteEmployeeDetails(Long id) {
        repository.deleteById(id);
    }
}
