
package com.spring.employeemgmt.controller;

import com.spring.employeemgmt.entity.EmployeeDetails;
import com.spring.employeemgmt.service.EmployeeDetailsService;

import java.util.List;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees/details")
public class EmployeeDetailsController {

    private final EmployeeDetailsService service;

    public EmployeeDetailsController(EmployeeDetailsService service) {
        this.service = service;
    }

    @PostMapping
    public EmployeeDetails create(@RequestBody EmployeeDetails employeeDetails) {
        return service.saveEmployeeDetails(employeeDetails);
    }

    @GetMapping("/{id}")
    public EmployeeDetails getById(@PathVariable Long id) {
        return service.getEmployeeDetailsById(id);
    }

    @GetMapping
    public List<EmployeeDetails> getAll() {
        return service.getAllEmployeeDetails();
    }

    @PutMapping("/{id}")
    public EmployeeDetails update(@PathVariable Long id, @RequestBody EmployeeDetails employeeDetails) {
        return service.updateEmployeeDetails(id, employeeDetails);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteEmployeeDetails(id);
    }
}