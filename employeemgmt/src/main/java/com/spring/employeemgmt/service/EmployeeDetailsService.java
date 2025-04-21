
package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.EmployeeDetails;
import com.spring.employeemgmt.repository.EmployeeDetailsRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeDetailsService {
    @Autowired
    private EmployeeDetailsRepository repository;

    public EmployeeDetails saveDetails(EmployeeDetails details) {
        return repository.save(details);
    }

    public EmployeeDetails saveEmployeeDetails(EmployeeDetails employeeDetails) {

        throw new UnsupportedOperationException("Unimplemented method 'saveEmployeeDetails'");
    }

    public EmployeeDetails getEmployeeDetailsById(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'getEmployeeDetailsById'");
    }

    public List<EmployeeDetails> getAllEmployeeDetails() {

        throw new UnsupportedOperationException("Unimplemented method 'getAllEmployeeDetails'");
    }

    public EmployeeDetails updateEmployeeDetails(Long id, EmployeeDetails employeeDetails) {

        throw new UnsupportedOperationException("Unimplemented method 'updateEmployeeDetails'");
    }

    public void deleteEmployeeDetails(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'deleteEmployeeDetails'");
    }
}
