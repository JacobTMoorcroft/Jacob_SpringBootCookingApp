package org.jacob_cooking_service.controller;

import org.jacob_cooking_service.entity.Ingredients;
import org.jacob_cooking_service.service.IngredientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ingredients")
public class IngredientsController {

    @Autowired
    private IngredientsService ingredientsService;

    @GetMapping
    public List<Ingredients> getAllIngredients(){
        return ingredientsService.getAllIngredients();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ingredients> getIngredients(@PathVariable Integer id){
        Ingredients ingredients = ingredientsService.getIngredientsById(id);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ingredients> saveIngredients(@RequestBody Ingredients ingredients){
        Ingredients savedIngredients = ingredientsService.saveIngredients(ingredients);
        return new ResponseEntity<>(savedIngredients, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Ingredients> updateIngredients(@PathVariable Integer id, @RequestBody Ingredients ingredients){
        Ingredients saveIngredients = ingredientsService.updateIngredients(id, ingredients);
        return new ResponseEntity<>(saveIngredients, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ingredients> deleteIngredients(@PathVariable Integer id) {
        Ingredients ingredients = ingredientsService.getIngredientsById(id);
        ingredientsService.deleteIngredients(id);
        return new ResponseEntity<>(ingredients, HttpStatus.OK);
    }

}
