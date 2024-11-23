package org.jacob_cooking_service.scheduler;


import org.jacob_cooking_service.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DeleteCurrentWeek {

    @Autowired
    private ScheduleService scheduleService;

    @Scheduled(cron = "0 24 4 * * WED")
    public void deleteWeek() {
        scheduleService.clearSchedule();

    }

}
