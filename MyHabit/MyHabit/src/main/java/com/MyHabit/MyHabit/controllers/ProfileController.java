package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.repositories.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {

    @Autowired
    ProfileRepo profileRepo;
}
