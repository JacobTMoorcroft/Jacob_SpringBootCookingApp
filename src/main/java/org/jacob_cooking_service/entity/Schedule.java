package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    private String day;

    private int day_id;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profiles profiles;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dishes dishes;

    public Schedule() {
    }

    public Schedule(String day, Profiles profiles, Dishes dishes) {
        this.day = day;
        this.profiles = profiles;
        this.dishes = dishes;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public int getDay_id() {
        return day_id;
    }

    public void setDay_id(int day_id) {
        this.day_id = day_id;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
    }

}