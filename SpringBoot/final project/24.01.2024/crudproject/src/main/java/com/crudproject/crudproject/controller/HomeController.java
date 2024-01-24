package com.crudproject.crudproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/home")
    public String home(){
        return "index";
    }


    @RequestMapping("/about")
    public String about(){
        return "about";
    }

    @RequestMapping("/resume")
    public String resume(){
        return "resume";
    }

    @RequestMapping("/protfolio")
    public String protfolio(){
        return "protfolio";
    }

    @RequestMapping("/services")
    public String services(){
        return "services";
    }


    @RequestMapping("/contact")
    public String contact(){
        return "contact";
    }

    @RequestMapping("/viewhotel")
    public String viewhotel(){
        return "hotel";
    }


}
