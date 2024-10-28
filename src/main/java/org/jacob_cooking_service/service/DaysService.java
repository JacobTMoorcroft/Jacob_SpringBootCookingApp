package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.Days;
import org.jacob_cooking_service.repositories.DaysRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DaysService {

    @Autowired
    private DaysRepository daysRepository;

    public List<Days> getAllDays() {
        return daysRepository.findAll();
    }
    // Optional<> returns a single object which may be empty allowing for additional methods later
    public Days getDaysById(Integer id){
        return daysRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Days saveDays(Days days){
        return daysRepository.save(days);
    }

    public Days updateDays(Integer id, Days days){
        Days existingIngredients = daysRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingIngredients.setDay_name(days.getDay_name());
        daysRepository.save(existingIngredients);

        return daysRepository.save(days);
    }

    public void deleteDays(Integer id){
        daysRepository.deleteById(id);
    }
}
