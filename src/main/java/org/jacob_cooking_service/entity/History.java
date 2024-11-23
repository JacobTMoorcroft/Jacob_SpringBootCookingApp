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
    private Profiles profiles;

    private String Date;

    public History (){

    }

    public History(Integer id, Dishes dishes, Profiles profile, String date) {
        this.id = id;
        this.dishes = dishes;
        this.profiles = profile;
        Date = date;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public Profiles getProfiles() {
        return profiles;
    }

    public void setProfiles(Profiles profiles) {
        this.profiles = profiles;
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
