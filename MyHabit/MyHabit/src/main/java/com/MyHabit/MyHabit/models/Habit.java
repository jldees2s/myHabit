package com.MyHabit.MyHabit.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Habit {

    @Id
    @GeneratedValue
    private int Id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

}
