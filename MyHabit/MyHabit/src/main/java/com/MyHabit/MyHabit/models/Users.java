package com.MyHabit.MyHabit.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

<<<<<<< HEAD
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
=======
import javax.persistence.*;
>>>>>>> main
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Users {

    @Id @GeneratedValue
    private int id;
    @NotNull
    private String userName;
    @NotNull
    private String passwordHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


    // table relationships
    @OneToMany
    private List<Habit> habits;

    // connection to user's profile table
    @OneToOne
    @JoinColumn(name = "user_id")
    private Profile profile;


    public Users(){}

    public Users(String uName, String password){
        this.userName = uName;
        this.passwordHash = encoder.encode(password);
    }

    public boolean isMatchingPassword(String password){
        return encoder.matches(password, passwordHash);
    }

    public String getUserName() {
        return userName;
    }

    public int getId(){
        return id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    //think i know how to fix this
    public void setPasswordHash(String password) {
        this.passwordHash = encoder.encode(password);
    }
}
