package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer profile_id;

    private String name;
    private String relation;

    public Profiles() {}

    public Profiles(String name, String relation) {
        this.name = name;
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public String getName() {
        return name;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setName(String name) {
        this.name = name;
    }
}