package com.MyHabit.MyHabit.controllers;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Controller
public class    HelloController {
    @GetMapping
    @ResponseBody
    public String hello() {
        return "Hello, Task Masters!";
    }
}
