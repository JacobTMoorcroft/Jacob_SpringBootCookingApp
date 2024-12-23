package org.jacob_cooking_service.scheduledServices;


import org.jacob_cooking_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AddToHistory {

    @Autowired
    private HistoryService historyService;

    @Scheduled(cron = "0 19 4 * * WED")
    public void addScheduleToHistory (){
        historyService.addScheduleToHistory();
    }
}
