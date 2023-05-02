package com.MyHabit.MyHabit.models;

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



}
