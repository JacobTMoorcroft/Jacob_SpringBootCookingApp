package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Days")
public class Days {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String day_name;

    public Days() {}

    public Days(String day_name) {
        this.day_name = day_name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getDay_name() {
        return day_name;
    }

    public void setDay_name(String day_name) {
        this.day_name = day_name;
    }
}
