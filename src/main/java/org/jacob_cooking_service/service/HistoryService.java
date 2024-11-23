package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.History;
import org.jacob_cooking_service.entity.Profiles;
import org.jacob_cooking_service.entity.Schedule;
import org.jacob_cooking_service.repositories.HistoryRepository;
import org.jacob_cooking_service.repositories.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    public List<History> getAllHistory() {
        return historyRepository.findAll();

    }

    public int getTotalTimeCooking(Profiles selectedProfile){
        List<History> profileHistories = historyRepository.findByProfiles(selectedProfile);
        int totalTimeCooking = 0;
        for (History history : profileHistories) {
            totalTimeCooking += Integer.parseInt(history.getDishes().getDishTime());
        }

        return totalTimeCooking;
    }

    public void addScheduleToHistory(){
        List<Schedule> schedules = scheduleRepository.findAll();
        List<History> histories = new ArrayList<>();



        for (Schedule schedule : schedules){
            History history = new History();

            history.setDishes(schedule.getDishes());
            history.setProfiles(schedule.getProfiles());
            histories.add(history);
        }
        historyRepository.saveAll(histories);
    }

}
