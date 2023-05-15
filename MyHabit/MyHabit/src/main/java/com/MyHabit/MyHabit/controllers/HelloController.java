package com.MyHabit.MyHabit.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class    HelloController {

    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello, Task Masters! Testing - Jordan";
    }
}
