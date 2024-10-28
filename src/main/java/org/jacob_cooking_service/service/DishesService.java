package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.Dishes;
import org.jacob_cooking_service.repositories.DishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class DishesService {

    @Autowired
    private DishesRepository dishesRepository;

    public List<Dishes> getAllDishes() {
        return dishesRepository.findAll();
    }
    // Optional<> returns a single object which may be empty allowing for additional methods later
    public Dishes getDishesById(Integer id){
        return dishesRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Dishes saveDishes(Dishes dishes){
        return dishesRepository.save(dishes);
    }

    public Dishes updateDishes(Integer id, Dishes dishes){
        Dishes existingIngredients = dishesRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingIngredients.setDish_name(dishes.getDish_name());
        dishesRepository.save(existingIngredients);

        return dishesRepository.save(dishes);
    }

    public void deleteDishes(Integer id){
        dishesRepository.deleteById(id);
    }
}
