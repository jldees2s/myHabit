package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profile {

    // FIELDS
    @Id
    @GeneratedValue
    private int id;

    // one user to one user profile, matched on userId
    @OneToOne
    private Users user;

    // maybe this should be userhabits?
    @OneToMany
    private List<Habit> habits;

    private String profileImageURL;
    private String status;
    private String bio;


    // CONSTRUCTORS
    public Profile() {}

    public Profile(int id, Users user, List<Habit> habits, String profileImageURL, String status, String bio) {
        this.id = id;
        this.user = user;
        this.habits = habits;
        this.profileImageURL = profileImageURL;
        this.status = status;
        this.bio = bio;
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<Habit> getHabits() {
        return habits;
    }

    public void setHabits(List<Habit> habits) {
        this.habits = habits;
    }

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
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
