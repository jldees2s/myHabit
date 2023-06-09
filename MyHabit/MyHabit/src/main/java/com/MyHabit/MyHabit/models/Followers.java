package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Followers {

  @Id
  @GeneratedValue
  private int id;

  //private Integer[] followerList;

  //would a many to many fix the issue of only 1 follower?
  @OneToMany
  @JoinColumn(name = "followerList")
  private List<Users> usersList;


  private int userId;

  public Followers(){
    this.usersList = new ArrayList<>();
  }

  public List<Users> getFollowerList() {
    return usersList;
  }

  //see about storing a json list
  public void addFollower(Users follower){
   usersList.add(follower);
    return;
  }

  public int getId(){return id;}

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }
}
