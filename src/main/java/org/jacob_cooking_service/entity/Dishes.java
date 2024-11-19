package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Dishes")
public class Dishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String dish_name;
    private String dishTime;
    private String imgURL;

    public Dishes(){}

    public Dishes(String dish_name, String dishTime, String imgURL) {
        this.dish_name = dish_name;
        this.dishTime = dishTime;
        this.imgURL = imgURL;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
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

    public String getDishTime() {
        return dishTime;
    }

    public void setDishTime(String dishTime) {
        this.dishTime = dishTime;
    }
}

