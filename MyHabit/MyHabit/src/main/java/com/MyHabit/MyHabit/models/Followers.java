package com.MyHabit.MyHabit.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
public class Followers {

  @Id
  @GeneratedValue
  private int id;

  private ArrayList<Optional<Users>> followerList;

//  @OneToMany
//  @JoinTable(name = "id")
//  private Users users;

  public Followers(){}

  public ArrayList<Optional<Users>> getFollowerList() {
    return followerList;
  }

  public void addFollower(Optional<Users> follower){
    followerList.add(follower);
  }

}
