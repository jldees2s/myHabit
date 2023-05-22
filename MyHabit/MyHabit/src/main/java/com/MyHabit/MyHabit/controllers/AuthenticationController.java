package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.DTO.LoginDTO;
import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.models.Users;
import com.MyHabit.MyHabit.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    //redo

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

    @PostMapping("/register")
    public String addUsers(String userName, String password) {
        Users existingUser = userRepo.getByUserName(userName);
        System.out.println(password);
        System.out.println(userName);
        //placeholder returns
        if (existingUser != null){
            return "login";
        } else {
            Users newUser = new Users(userName, password);
            userRepo.save(newUser);
            return "home";
        }
    }

    @PostMapping
    public String loginUser(LoginDTO loginDTO){
        Users existingUser = userRepo.getByUserName(loginDTO.getUserName());

        if (existingUser == null){
            return "please register first";
        }
        if (existingUser.isMatchingPassword(loginDTO.getPassword())){
            return "login successful";
        } else{
           return "oops";
        }

    }
}
