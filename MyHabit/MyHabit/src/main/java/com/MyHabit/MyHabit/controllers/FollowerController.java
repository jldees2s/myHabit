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
  public ResponseEntity getFollowerList(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findByUserId(followerDTO.getUserID());
    Optional<Users> optionalBackupUser = userRepo.findById(followerDTO.getUserID());Followers existingUser = optionalUser.get();
    Users backupUser = optionalBackupUser.get();
    System.out.println(existingUser);
    //System.out.println(backupUser);
    return new ResponseEntity<>(existingUser.getFollowerList(), HttpStatus.OK);
  }

  //says a dto might work
  //nope

  //idea to try later is to make a follower class again and give it a many to many relationship
  @PostMapping
  public ResponseEntity addFollower(@RequestBody FollowerDTO followerDTO){
    Optional<Followers> optionalUser = followerRepo.findByUserId(followerDTO.getUserID());
    Optional<Users> optionalFollower = userRepo.findById(followerDTO.followerId);
    Optional<Users> optionalBackupUser = userRepo.findUsersById(followerDTO.getUserID());
    System.out.println(optionalUser);
     System.out.println(optionalFollower);
    System.out.println(optionalBackupUser);
    System.out.println(followerDTO.getUserID());
    if (optionalUser.isPresent()) {
      Followers existingUser = optionalUser.get();
      Users follower = optionalFollower.get();
      System.out.println(follower);
      existingUser.addFollower(follower);
      followerRepo.save(existingUser);
    } else{
      //Users backupUser = optionalBackupUser.get();
       Followers existingUser = new Followers();
      existingUser.setUserId(followerDTO.getUserID());
      Users follower = optionalFollower.get();
      existingUser.addFollower(follower);
      followerRepo.save(existingUser);
   }
    return new  ResponseEntity<String>("done", HttpStatus.OK);
  }

}
