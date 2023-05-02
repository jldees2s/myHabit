package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.repositories.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/habit")
public class HabitController {

    @Autowired
    HabitRepo habitRepo;

    @GetMapping
    @ResponseBody
    public String sayHello(){
        return "Habit hello!";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public Habit addHabit(@RequestBody Habit habit) {
        Habit newHabit = habitRepo.save(habit);
                return newHabit;
    }
}
