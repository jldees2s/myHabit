package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserHabit{

    // FIELDS
    @Id
    @GeneratedValue
    private int id;

    // private ??? startDate
    // private ??? endDate
    private boolean active;
    private boolean complete;
    private boolean hidden;

    // table relationships
    @OneToMany
    @JoinColumn(name = "user_id")
    private List<Habit> habit;


    // CONSTRUCTORS
    public UserHabit() {}


    // GETTERS & SETTERS
    public int getId() {
        return id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isHidden() {
        return hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
}
