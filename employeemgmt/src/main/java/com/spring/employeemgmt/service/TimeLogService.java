
package com.spring.employeemgmt.service;

import com.spring.employeemgmt.entity.TimeLog;
import java.util.List;

public interface TimeLogService {
    List<TimeLog> getAllTimeLogs();

    TimeLog getTimeLogById(Long id);

    TimeLog createTimeLog(TimeLog timeLog);

    TimeLog updateTimeLog(Long id, TimeLog timeLog);

    void deleteTimeLog(Long id);
}
