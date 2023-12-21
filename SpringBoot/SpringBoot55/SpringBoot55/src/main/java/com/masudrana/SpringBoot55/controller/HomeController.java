package com.masudrana.SpringBoot55.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {



    @GetMapping("/")
    public String home(){

        return "home";
    }

    @GetMapping(value = {"/masud/","/abc/"})
    public String masud(){

        return "masud";
    }
}
