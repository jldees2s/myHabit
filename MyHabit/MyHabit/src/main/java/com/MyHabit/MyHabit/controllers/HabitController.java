package com.MyHabit.MyHabit.controllers;

import com.MyHabit.MyHabit.models.Habit;
import com.MyHabit.MyHabit.repositories.HabitRepo;
import org.hibernate.sql.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

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

    @DeleteMapping("/delete/{id}")
    public Boolean deleteHabit(@PathVariable("id") int id) {
        if(!habitRepo.findById(id).equals(Optional.empty())){
            habitRepo.deleteById(id);
            return true;
        }
       return false;
    }
}