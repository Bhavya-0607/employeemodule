package com.spring.employeemgmt.controller;

import com.spring.employeemgmt.entity.TimeLog;
import com.spring.employeemgmt.service.TimeLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/timelogs")
public class TimeLogController {

    @Autowired
    private TimeLogService timeLogService;

    @GetMapping
    public List<TimeLog> getAllTimeLogs() {
        return timeLogService.getAllTimeLogs();
    }

    @GetMapping("/{id}")
    public TimeLog getTimeLogById(@PathVariable Long id) {
        return timeLogService.getTimeLogById(id);
    }

    @PostMapping
    public TimeLog createTimeLog(@RequestBody TimeLog timeLog) {
        return timeLogService.createTimeLog(timeLog);
    }

    @PutMapping("/{id}")
    public TimeLog updateTimeLog(@PathVariable Long id, @RequestBody TimeLog timeLog) {
        return timeLogService.updateTimeLog(id, timeLog);
    }

    @DeleteMapping("/{id}")
    public void deleteTimeLog(@PathVariable Long id) {
        timeLogService.deleteTimeLog(id);
    }
}
