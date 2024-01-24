package com.crudproject.crudproject.controller;

import com.crudproject.crudproject.model.User;
import com.crudproject.crudproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signup")

public class SignupController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String showSignupForm() {
        return "user/signup";
    }

    @PostMapping
    public String processSignup(User user){
        userRepository.save(user);
        return "redirect:/signin";
    }

}
