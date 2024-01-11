package com.project.projectTemplate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class homeController {

    @GetMapping("/home")
    public String home(){
        return "index";
    }

    @GetMapping("/header")
    public String header(){
        return "header";
    }

    @GetMapping("/footer")
    public String footer(){
        return "footer";
    }

}
