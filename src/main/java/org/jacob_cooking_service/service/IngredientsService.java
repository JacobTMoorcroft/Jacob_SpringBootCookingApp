package org.jacob_cooking_service.service;

import org.jacob_cooking_service.entity.Ingredients;
import org.jacob_cooking_service.repositories.IngredientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class IngredientsService {

    @Autowired
    private IngredientsRepository ingredientsRepository;

    public List<Ingredients> getAllIngredients() {
        return ingredientsRepository.findAll();
    }
    // Optional<> returns a single object which may be empty allowing for additional methods later
    public Ingredients getIngredientsById(Integer id){
        return ingredientsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public Ingredients saveIngredients(Ingredients ingredients){
        return ingredientsRepository.save(ingredients);
    }

    public Ingredients updateIngredients(Integer id, Ingredients ingredients){
        Ingredients existingIngredients = ingredientsRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
        existingIngredients.setIngredient_name(ingredients.getIngredient_name());
        ingredientsRepository.save(existingIngredients);

        return ingredientsRepository.save(ingredients);
    }

    public void deleteIngredients(Integer id){
        ingredientsRepository.deleteById(id);
    }
}
