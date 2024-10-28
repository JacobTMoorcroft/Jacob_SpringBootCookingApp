package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dish_id;

    private String dish_name;

    public Dishes(){}

    public Dishes(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
}
