package com.MyHabit.MyHabit.models;

import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
public class Profile {

    // FIELDS
    @Id // primary key
    @GeneratedValue
    @Column(nullable = false, updatable = false) // cannot be changed once its set
    private int id;

    @NotBlank
    @Size(min = 1, max = 35)
    private String firstName;

    @NotBlank
    @Size(min = 1, max = 35)
    private String lastName;

    @NotBlank
    @Size(min = 1, max = 35)
    private String displayName; // the name a user wants to display on their profile, instead of their first and last names

    @NotBlank
    @Email
    private String email;

    // optional fields
    @Size(min = 1, max = 35)
    private String location;

    @Size(max = 150)
    private String status;

    @Size(max = 500)
    private String bio;

    @URL
    private String profileImageURL;


    // TABLE RELATIONSHIPS
    // one profile to one user, matched on userId
    @OneToOne
    private Users user;

    // one profile to many userhabits, matched on user_habit_id
    // this should be userhabits, but userhabits is not accessible on this branch
    @OneToMany
    private List<Habit> habits;


    // CONSTRUCTORS
    public Profile() {}

    public Profile(String firstName, String lastName, String displayName, String email, String location, String status, String bio, String profileImageURL, Users user, List<Habit> habits) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.displayName = displayName;
        this.email = email;
        this.location = location;
        this.status = status;
        this.bio = bio;
        this.profileImageURL = profileImageURL;
        this.user = user;
        this.habits = habits;
    }

    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public String getProfileImageURL() {
        return profileImageURL;
    }

    public void setProfileImageURL(String profileImageURL) {
        this.profileImageURL = profileImageURL;
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

    @Override
    public String toString() {
        return "Profile Information \n" +
                "Profile Id: " + id +
                "First Name: " + firstName + '\n' +
                "Last Name: " + lastName + '\n' +
                "Display Name: " + displayName + '\n' +
                "Email: " + email + '\n' +
                "Location: " + location + '\n' +
                "Status: " + status + '\n' +
                "Bio: " + bio + '\n' +
                "Profile Image: " + profileImageURL + '\n' +
                "Habits: " + habits + '\n';
    }
}
