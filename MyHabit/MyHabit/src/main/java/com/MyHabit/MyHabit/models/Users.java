package com.MyHabit.MyHabit.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Users {

    @Id @GeneratedValue
    private int id;
    @NotNull
    private String userName;
    @NotNull
    private String passwordHash;
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

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
