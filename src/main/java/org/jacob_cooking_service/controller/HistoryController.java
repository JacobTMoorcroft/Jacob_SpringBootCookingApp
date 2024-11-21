package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @postMapping
    public ResponseEntity postWeek(){
        historyService.saveHistory();
        return new ResponseEntity()
    }
}
