package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "day_id", nullable = false)
    private Days days;

    @ManyToOne
    @JoinColumn(name = "profile_id", nullable = false)
    private Profiles profiles;

    @ManyToOne
    @JoinColumn(name = "dish", nullable = false)
    private Dishes dishes;

    public Schedule() {}

    public Schedule(Days days, Profiles profiles, Dishes dishes) {
        this.days = days;
        this.profiles = profiles;
        this.dishes = dishes;
    }

    public Dishes getDishes() {
        return dishes;
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

    public Days getDays() {
        return days;
    }

    public void setDays(Days days) {
        this.days = days;
    }
}

