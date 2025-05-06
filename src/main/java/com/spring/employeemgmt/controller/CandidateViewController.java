
package com.spring.employeemgmt.controller;

import com.spring.employeemgmt.entity.CandidateView;
import com.spring.employeemgmt.service.CandidateViewService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/candidate-views")
@RequiredArgsConstructor
public class CandidateViewController {

    private final CandidateViewService viewService;

    @PostMapping
    public ResponseEntity<CandidateView> createView(@RequestBody CandidateView view) {
        return ResponseEntity.ok(viewService.saveView(view, null));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<Object> getViewsByUser(@PathVariable String userId) {
        return ResponseEntity.ok(viewService.getViewsByUser(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CandidateView> getViewById(@PathVariable Long id) {
        CandidateView view = viewService.getViewById(id);
        return view != null ? ResponseEntity.ok(view) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteView(@PathVariable Long id) {
        viewService.deleteView(id);
        return ResponseEntity.noContent().build();
    }
}
