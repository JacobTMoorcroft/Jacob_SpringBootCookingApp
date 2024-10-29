package org.jacob_cooking_service.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Ingredients")
public class Ingredients {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String ingredient_name;

    public Ingredients(){}

    public Ingredients(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }

    public String getIngredient_name() {
        return ingredient_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setIngredient_name(String ingredient_name) {
        this.ingredient_name = ingredient_name;
    }
}
