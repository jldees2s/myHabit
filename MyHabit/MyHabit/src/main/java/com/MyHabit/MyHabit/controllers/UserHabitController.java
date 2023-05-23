package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.repositories.UserHabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-habit")
public class UserHabitController {

    @Autowired
    UserHabitRepo userHabitRepo;
}
