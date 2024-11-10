package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String profile_name;
    private String relation;

    public Profiles() {}

    public Profiles(String profile_name, String relation) {
        this.profile_name = profile_name;
        this.relation = relation;
    }

    public String getRelation() {
        return relation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProfile_name() {
        return profile_name;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }

    public void setProfile_name(String name) {
        this.profile_name = name;
    }
}
