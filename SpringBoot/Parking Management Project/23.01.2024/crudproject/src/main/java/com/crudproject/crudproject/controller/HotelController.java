package com.crudproject.crudproject.controller;


import com.crudproject.crudproject.model.Hotel;
import com.crudproject.crudproject.repository.HotelRepository;
import com.crudproject.crudproject.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller

public class HotelController {

//    @Autowired
//    HotelService hotelService;
//
//    @RequestMapping("/viewhotel")
//    public String viewhotel(){
//        return "hotel";
//    }

    private HotelRepository hotelRepository;



    @Autowired
    public HotelController(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }



    @GetMapping("/hotel")
    public String showHotelForm(Model model){
        model.addAttribute("saveForm", new Hotel());
        return "hotel";
    }

    @PostMapping("/save")
    public  String saveData(@ModelAttribute Hotel hotel){
       hotelRepository.save(hotel);
        return "redirect:/hotel";
    }


    @GetMapping("/viewAllHotels")
    public String viewAllHotels(Model model){

        List<Hotel> storeData= hotelRepository.findAll();

        model.addAttribute("hotels", storeData);



        return  "viewAllHotels";
    }


    @GetMapping("/deleteHotel/{id}")
    public String deleteHotel(@PathVariable int id) {
        hotelRepository.deleteById(id);
        return "redirect:/viewAllHotels";
    }


    @GetMapping("/updateHotel/{id}")
    public String updateHotel(@PathVariable("id") int id, Model model){
        Optional<Hotel> hotelData=hotelRepository.findById(id);
        model.addAttribute("hotel", hotelData.orElse(null));
        return "updateHotel";

    }

    @PostMapping("/updateData")
     public   String updateD(@ModelAttribute Hotel hotel){
        hotelRepository.save(hotel);
        return "redirect:/viewAllHotels";
    }

}
