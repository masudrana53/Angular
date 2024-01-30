package com.crudproject.crudproject.controller;

import com.crudproject.crudproject.model.User;
import com.crudproject.crudproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SigninController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signin")
    public String showSigninForm(){
        return "user/signin";
    }


    @PostMapping("/signin")
    public String processSignin(User user, Model model) {
        // Check if the user exists with the provided username and password
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());

        if (existingUser != null) {
            // User exists, redirect to the home page or any other destination
            return "redirect:/";
        } else {
            // User does not exist or credentials are incorrect, display an error message
            model.addAttribute("error", "Invalid username or password");
            return "user/signin";
        }
    }


}
