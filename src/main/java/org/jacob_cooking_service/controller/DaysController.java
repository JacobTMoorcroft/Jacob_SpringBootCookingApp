package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.entity.Days;
import org.jacob_cooking_service.service.DaysService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/days")
public class DaysController {

    @Autowired
    private DaysService daysService;

    @GetMapping
    public List<Days> getAllIngredients(){
        return daysService.getAllDays();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Days> getIngredients(@PathVariable Integer id){
        Days days = daysService.getDaysById(id);
        return new ResponseEntity<>(days, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Days> saveIngredients(@RequestBody Days days){
        Days savedDays = daysService.saveDays(days);
        return new ResponseEntity<>(savedDays, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Days> updateIngredients(@PathVariable Integer id, @RequestBody Days days){
        Days saveDays = daysService.updateDays(id, days);
        return new ResponseEntity<>(saveDays, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Days> deleteIngredients(@PathVariable Integer id) {
        Days days = daysService.getDaysById(id);
        daysService.deleteDays(id);
        return new ResponseEntity<>(days, HttpStatus.OK);
    }
}
