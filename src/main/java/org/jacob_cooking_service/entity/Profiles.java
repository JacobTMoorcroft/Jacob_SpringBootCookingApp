package org.jacob_cooking_service.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Profiles")
public class Profiles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String profile_name;

    public Profiles() {}

    public Profiles(String profile_name) {
        this.profile_name = profile_name;

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



    public void setProfile_name(String name) {
        this.profile_name = name;
    }
}
