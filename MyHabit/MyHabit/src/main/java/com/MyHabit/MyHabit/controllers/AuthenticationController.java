package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    UserRepo userRepo;

    private static final String userSessionKey = "user";

    @GetMapping
    @ResponseBody
    public String sayHello(){
        return "Test hello";
    }

    private static void setUserInSession(HttpSession session, Users user){
        session.setAttribute(userSessionKey, user.getId());
    }

    public Users getUserFromSession(HttpSession session){

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        if(userId == null){
            return null;
        }

        Optional<Users> usersOptional = userRepo.findById(userId);

        if (usersOptional.isEmpty()){
            return null;
        }
        return usersOptional.get();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Users addUsers(@RequestBody Users user) {
        Users newUser = userRepo.save(user);
        return newUser;
    }
}
