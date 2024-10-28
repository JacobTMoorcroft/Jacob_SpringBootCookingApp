package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.entity.Dishes;
import org.jacob_cooking_service.service.DishesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @GetMapping
    public List<Dishes> getAllDishes(){
        return dishesService.getAllDishes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dishes> getDishes(@PathVariable Integer id){
        Dishes savedDishes = dishesService.getDishesById(id);
        return new ResponseEntity<>(savedDishes, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Dishes> saveDishes(@RequestBody Dishes dishes){
        Dishes savedDishes = dishesService.saveDishes(dishes);
        return new ResponseEntity<>(savedDishes, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Dishes> updateDishes(@PathVariable Integer id, @RequestBody Dishes dishes){
        Dishes savedDishes = dishesService.updateDishes(id, dishes);
        return new ResponseEntity<>(savedDishes, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Dishes> deleteDishes(@PathVariable Integer id) {
        Dishes savedDishes = dishesService.getDishesById(id);
        dishesService.deleteDishes(id);
        return new ResponseEntity<>(savedDishes, HttpStatus.OK);
    }
}
