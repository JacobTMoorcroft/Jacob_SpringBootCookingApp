package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.History;
import org.jacob_cooking_service.repositories.HistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    public List<History> getAllHistory() {
        return historyRepository.findAll();

    }

    public String getTotalTimeCooking(){


    }

    public

}
