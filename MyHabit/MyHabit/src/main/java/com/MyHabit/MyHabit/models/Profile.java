package com.MyHabit.MyHabit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profile {

    // FIELDS
    @Id
    @GeneratedValue
    private int id;

    // private ??? profileImage;
    // private int userId;
    private String status;
    private String bio;
    // private ??? profileBackground;

    // CONSTRUCTORS

    public Profile() {}

//    public Profile(int id, String status, String bio) {
//        this.id = id;
//        this.status = status;
//        this.bio = bio;
//    }

    // GETTERS & SETTERS


    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
