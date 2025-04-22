package com.spring.employeemgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.employeemgmt.entity.ViewConfig;

@Repository
public interface ViewConfigRepository extends JpaRepository<ViewConfig, Long> {
    // Additional query methods can be added here if needed
}
