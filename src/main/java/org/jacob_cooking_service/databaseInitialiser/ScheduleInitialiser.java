package org.jacob_cooking_service.databaseInitialiser;


import jakarta.annotation.PostConstruct;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ScheduleInitialiser {


    @Autowired
    private ScheduleRepository scheduleRepository;

    @PostConstruct
    public void initScheduleData() {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        int[] day_id = {1,2,3,4,5};
        for (int i = 0; i < days.length; i++) {
            if (!scheduleRepository.existsById(days[i])) {
                Schedule schedule = new Schedule();
                schedule.setDay(days[i]);
                schedule.setDay_id(day_id[i]);
                scheduleRepository.save(schedule);
            }
        }
    }
}
