package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dish_name;

    public Dishes(){}

    public Dishes(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getDish_name() {
        return dish_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }
}
