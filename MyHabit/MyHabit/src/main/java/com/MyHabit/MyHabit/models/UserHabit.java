package com.MyHabit.MyHabit.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class UserHabit extends Habit{

    // FIELDS
    // inherits id, name, description from Habit class

//    @ManyToOne

    private Users userId;

    private boolean active;
    private boolean complete;
    private boolean hidden;

    // CONSTRUCTORS
    public UserHabit() {}

    public UserHabit(Users userId, boolean active, boolean complete, boolean hidden) {
        super();
        this.userId = userId;
        this.active = active;
        this.complete = complete;
        this.hidden = hidden;
    }

    // GETTERS & SETTERS

    public Users getUserId() {
        return userId;
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
