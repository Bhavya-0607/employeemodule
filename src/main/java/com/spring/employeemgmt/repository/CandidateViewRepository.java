
package com.spring.employeemgmt.repository;

import com.spring.employeemgmt.entity.CandidateView;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateViewRepository extends JpaRepository<CandidateView, Long> {

    List<CandidateView> findByCreatedBy(String createBy);
}
