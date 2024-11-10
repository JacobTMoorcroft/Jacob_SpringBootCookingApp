package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        return new ResponseEntity<>(scheduleService.getAllSchedule(), HttpStatus.OK);
    }

    @PatchMapping("/{day}")
    public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule, @PathVariable String day){
        Schedule updateSchedule = scheduleService.updateSchedule(day, schedule);
        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{day}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable String day){
        return new ResponseEntity<>(scheduleService.deleteSchedule(day), HttpStatus.OK);
    }

}
