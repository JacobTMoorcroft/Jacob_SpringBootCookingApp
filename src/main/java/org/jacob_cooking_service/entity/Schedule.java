package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "day_id", referencedColumnName = "id")
    private Days days;

    @ManyToOne(optional = false)
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profiles profiles;

    @ManyToOne(optional = false)
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
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

