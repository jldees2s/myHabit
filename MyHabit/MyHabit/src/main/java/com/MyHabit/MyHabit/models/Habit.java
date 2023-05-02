package com.MyHabit.MyHabit.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Habit {

    @Id
    @GeneratedValue
    private int Id;
    private String name;
    private String description;


}
