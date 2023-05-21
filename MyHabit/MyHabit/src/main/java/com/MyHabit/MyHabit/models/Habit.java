package com.MyHabit.MyHabit.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Habit {

    @Id
    @GeneratedValue
    private int id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    // table relationships
    @ManyToOne
    private Users user;

    @ManyToOne
    @JoinColumn(name = "habit_id")
    private UserHabit habitSettings;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

}
