package org.jacob_cooking_service.service;



import org.jacob_cooking_service.entity.Schedule;
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


    public List<Schedule> getAllSchedule(){
        return scheduleRepository.findAll();
    }

    public Schedule updateSchedule(String day, Schedule schedule){
        Schedule saveSchedule = scheduleRepository.findById(day).orElseThrow(() -> new RuntimeException("Not Found"));

        if (schedule.getProfiles() != null) {
            saveSchedule.setProfiles(profilesRepository.findById(schedule.getProfiles().getId()).orElseThrow(() -> new RuntimeException("Not Found")));
        }

        if (schedule.getDishes() != null){
            saveSchedule.setDishes(dishesRepository.findById(schedule.getDishes().getId()).orElseThrow(() -> new RuntimeException("Not Found")));
        }


        return scheduleRepository.save(saveSchedule);

    }

    public Schedule deleteSchedule(String day){
        Schedule saveSchedule = scheduleRepository.findById(day).orElseThrow(() -> new RuntimeException("Not Found"));
        scheduleRepository.deleteById(day);
        return saveSchedule;
    }

}
