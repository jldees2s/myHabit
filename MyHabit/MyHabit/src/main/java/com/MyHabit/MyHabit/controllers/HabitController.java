package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.repositories.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HabitController {

    @Autowired
    HabitRepo habitRepo;
}
