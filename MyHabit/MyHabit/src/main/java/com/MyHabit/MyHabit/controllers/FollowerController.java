package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.DTO.FollowerDTO;
import com.MyHabit.MyHabit.models.Followers;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.FollowerRepo;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/follow")
public class FollowerController {

  @Autowired
  private FollowerRepo followerRepo;

  @Autowired
  private UserRepo userRepo;

  @GetMapping
  public ResponseEntity getFollowerList(@RequestBody int userID){
    Optional<Followers> existingUser = followerRepo.findById(userID);
    return new ResponseEntity<>(existingUser.get().getFollowerList(), HttpStatus.OK);
  }

  //says a dto might work
  //nope

  //idea to try later is to make a follower class again and give it a many to many relationship
  @PostMapping
  public ResponseEntity addFollower(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findById(followerDTO.getUserID());
    Optional<Users> follower = userRepo.findUsersById(followerDTO.getFollowerId());
    if (optionalUser.isPresent()) {
      Followers existingUser = optionalUser.get();
      followerRepo.save(existingUser);
    }
    return new  ResponseEntity<String>("done", HttpStatus.OK);
  }

}
