package org.jacob_cooking_service;


import org.jacob_cooking_service.entity.Days;
import org.jacob_cooking_service.entity.Dishes;
import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.repositories.DaysRepository;
import org.jacob_cooking_service.repositories.DishesRepository;
import org.jacob_cooking_service.repositories.ProfilesRepository;
import org.jacob_cooking_service.repositories.ScheduleRepository;
import org.jacob_cooking_service.service.ScheduleService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBootTest
public class ScheduleServiceTest {


    @Mock
    private ScheduleRepository scheduleRepository;
    @Mock
    private ProfilesRepository profilesRepository;
    @Mock
    private DishesRepository dishesRepository;
    @Mock
    private DaysRepository daysRepository;

    @Autowired
    private ScheduleService scheduleService;


    @BeforeEach
    void setUp(){

    }

    @Test
    void testCreateSchedule(){

        // Mimic Input data, a schedule object with only the values of the key being not null

        Days days = new Days();
        Profiles profiles = new Profiles();
        Dishes dishes = new Dishes();

        days.setId(2);
        profiles.setId(1);
        dishes.setId(3);

        Schedule schedule = new Schedule();
        schedule.setDays(days);
        schedule.setProfiles(profiles);
        schedule.setDishes(dishes);

        when(profilesRepository.findById(profiles.getId())).thenReturn(java.util.Optional.of(profiles));
        when(daysRepository.findById(profiles.getId())).thenReturn(java.util.Optional.of(days));
        when(dishesRepository.findById(profiles.getId())).thenReturn(java.util.Optional.of(dishes));
        when(scheduleRepository.save(schedule)).thenReturn(schedule);

        Schedule createSchedule = scheduleService.createSchedule(schedule);

        assertNotNull(createSchedule, "Should return a value and not be null");

    }


}
