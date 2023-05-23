package com.MyHabit.MyHabit.models;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

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
    @ManyToOne // many habits to one user
    @JoinColumn(name = "user_id")
    private Users user;

    @OneToOne // one habit to one habit settings
    @JoinColumn(name = "id")
    private HabitSettings habitSettings;

    @ManyToOne // many habits to one profile
    @JoinColumn(name = "profile_id")
    private Profile profile;



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
