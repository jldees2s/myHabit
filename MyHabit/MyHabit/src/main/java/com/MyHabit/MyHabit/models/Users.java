package com.MyHabit.MyHabit.models;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
