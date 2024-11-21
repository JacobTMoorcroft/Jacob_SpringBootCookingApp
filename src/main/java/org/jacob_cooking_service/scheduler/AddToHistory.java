package org.jacob_cooking_service.scheduler;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class AddToHistory {

    @Scheduled(cron = "0 19 4 * * WED")
    public void addToHistory
}
