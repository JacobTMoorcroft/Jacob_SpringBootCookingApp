package org.jacob_cooking_service.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "History")
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "dish_id", referencedColumnName = "id")
    private Dishes dishes;

    @ManyToOne
    @JoinColumn(name = "profile_id", referencedColumnName = "id")
    private Profiles profile;
    private int Date;

    public History (){

    }

    public History(Integer id, Dishes dishes, Profiles profile, int date) {
        this.id = id;
        this.dishes = dishes;
        this.profile = profile;
        Date = date;
    }

    public int getDate() {
        return Date;
    }

    public void setDate(int date) {
        Date = date;
    }

    public Profiles getProfile() {
        return profile;
    }

    public void setProfile(Profiles profile) {
        this.profile = profile;
    }

    public Dishes getDishes() {
        return dishes;
    }

    public void setDishes(Dishes dishes) {
        this.dishes = dishes;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
