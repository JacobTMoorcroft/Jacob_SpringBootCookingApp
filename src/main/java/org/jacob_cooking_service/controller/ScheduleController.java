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
    public ResponseEntity<List<Schedule>> getAllSchedule() {
        return new ResponseEntity<>(scheduleService.getAllSchedule(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Schedule> saveSchedule(@RequestBody Schedule schedule) {
        Schedule savedSchedule = scheduleService.createSchedule(schedule);
        return new ResponseEntity<>(savedSchedule, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@RequestBody Schedule schedule, @PathVariable Integer id){
        Schedule updateSchedule = scheduleService.alterSchedule(id, schedule);
        return new ResponseEntity<>(updateSchedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable Integer id){
        return new ResponseEntity<>(scheduleService.deleteSchedule(id), HttpStatus.OK);
    }

}
