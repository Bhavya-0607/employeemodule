
package com.spring.employeemgmt.repository;

import com.spring.employeemgmt.entity.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDetailsRepository extends JpaRepository<EmployeeDetails, Long> {
}
