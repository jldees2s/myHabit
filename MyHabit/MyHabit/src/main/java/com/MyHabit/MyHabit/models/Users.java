package com.MyHabit.MyHabit.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Users {

    @Id @GeneratedValue
    private int id;

}
