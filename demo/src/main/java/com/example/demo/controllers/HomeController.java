package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/")
public class HomeController {
    @GetMapping
    public String getHome() {
        //https://www.youtube.com/watch?v=YZZbl5yA_Hs&list=PLp4DtrLRhb24V67po4dhTMiVm2YBYGmlF&index=29
        return "Hello from Home page in 25 Hibernate and SpringData! :))";
    }
}
