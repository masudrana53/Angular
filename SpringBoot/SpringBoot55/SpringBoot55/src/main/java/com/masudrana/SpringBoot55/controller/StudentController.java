package com.masudrana.SpringBoot55.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("")
    public String AllStudent(){

        return "student";
    }

    @GetMapping("/rana")
    public String student(){

        return "masud";
    }

}
