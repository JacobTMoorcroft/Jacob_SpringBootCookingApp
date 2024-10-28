package org.jacob_cooking_service.service;

import jakarta.persistence.EntityNotFoundException;
import org.jacob_cooking_service.entity.Days;
import org.jacob_cooking_service.entity.Dishes;
import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.repositories.DaysRepository;
import org.jacob_cooking_service.repositories.DishesRepository;
import org.jacob_cooking_service.repositories.ProfilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.jacob_cooking_service.repositories.ScheduleRepository;
import java.util.List;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private DishesRepository dishesRepository;
    @Autowired
    private DaysRepository daysRepository;


    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public Schedule createSchedule(Schedule schedule){
        Dishes dish = dishesRepository.findById(schedule.getDishes().getId())
                .orElseThrow(() -> new EntityNotFoundException("Dish not found"));
        Profiles profile = profilesRepository.findById(schedule.getProfiles().getId())
                .orElseThrow(() -> new EntityNotFoundException("Profile not found"));
        Days day = daysRepository.findById(schedule.getDays().getId())
                .orElseThrow(() -> new EntityNotFoundException("Day not found"));

        schedule.setProfiles(profile);
        schedule.setDishes(dish);
        schedule.setDays(day);


        return scheduleRepository.save(schedule);

    }

    public Schedule alterSchedule(Integer id, Schedule schedule){
        Schedule saveSchedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        if (schedule.getDays() != null) {
            saveSchedule.setDays(schedule.getDays());
        }
        if (schedule.getProfiles() != null) {
            saveSchedule.setProfiles(schedule.getProfiles());
        }
        if (schedule.getDishes() != null ){
            saveSchedule.setDishes(schedule.getDishes());
        }

        return scheduleRepository.save(saveSchedule);

    }

    public Schedule deleteSchedule(Integer id){
        Schedule saveSchedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        scheduleRepository.deleteById(id);
        return saveSchedule;
    }

}
