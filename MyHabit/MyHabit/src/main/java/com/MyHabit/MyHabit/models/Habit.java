package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Habit {

  // FIELDS
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


  // CONSTRUCTORS
  public Habit() {
  }

  public Habit(String name, String description, Users user, HabitSettings habitSettings, Profile profile) {
    this.name = name;
    this.description = description;
    this.user = user;
    this.habitSettings = habitSettings;
    this.profile = profile;
  }

  // GETTERS & SETTERS
  public int getId() {
    return id;
  }

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

  public Users getUser() {
    return user;
  }

  public void setUser(Users user) {
    this.user = user;
  }

  public HabitSettings getHabitSettings() {
    return habitSettings;
  }

  public void setHabitSettings(HabitSettings habitSettings) {
    this.habitSettings = habitSettings;
  }

  public Profile getProfile() {
    return profile;
  }

  public void setProfile(Profile profile) {
    this.profile = profile;
  }

  @Override
  public String toString() {
    return "Habit" +
      "Habit Id:" + id + '\n' +
      "Name: " + name + '\n' +
      "Description: " + description + '\n' +
      "User Id: " + user + '\n' +
      "Associated User Profile Id: " + profile + '\n' +
      "User's Habit Settings: " + habitSettings + '\n';
  }
}
