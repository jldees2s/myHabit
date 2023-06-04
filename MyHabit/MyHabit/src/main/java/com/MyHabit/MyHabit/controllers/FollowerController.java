package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;


@RestController
@RequestMapping("/follow")
public class FollowerController {

  @Autowired
  private UserRepo userRepo;

  @GetMapping
  public ResponseEntity getFollowerList(@RequestBody int userID){
    Optional<Users> existingUser = userRepo.findById(userID);
    return new ResponseEntity<>(existingUser.get().getFollowerList(), HttpStatus.OK);
  }


}
