package com.crudproject.crudproject.controller;

import com.crudproject.crudproject.model.Booking;
import com.crudproject.crudproject.model.Parking;
import com.crudproject.crudproject.model.Slots;
import com.crudproject.crudproject.service.BookingService;
import com.crudproject.crudproject.service.ParkingService;
import com.crudproject.crudproject.service.SlotsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/parkings")
public class ParkingController {

    private final ParkingService parkingService;

    private final BookingService bookingService;

    private final SlotsServices slotsServices;



    @Autowired
    public ParkingController(ParkingService parkingService, BookingService bookingService, SlotsServices slotsServices) {
        this.parkingService = parkingService;
        this.bookingService = bookingService;
        this.slotsServices = slotsServices;
    }

    @GetMapping
    public String getAllParkings(Model model) {
        List<Parking> parkings = parkingService.getAllParkings();
        model.addAttribute("parkings", parkings);
        return "/parking-list";
    }

    @GetMapping("/{id}")
    public String getParkingById(@PathVariable int id, Model model) {
        Optional<Parking> parking = parkingService.getParkingById(id);
        parking.ifPresent(value -> model.addAttribute("parking", value));
        return "/parking-details";
    }

    @GetMapping("/parkingform")
    public String showParkingForm(Model model) {
        model.addAttribute("parkings", new Parking());
        return "/parking-form";
    }

    @PostMapping("/new")
    public String saveParking(@ModelAttribute Parking parking) {
        parkingService.saveParking(parking);
        return "redirect:/parkings";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Optional<Parking> parking = parkingService.getParkingById(id);
        parking.ifPresent(value -> model.addAttribute("parking", value));
        return "/parking-edit-form";
    }

    @PostMapping("/edit/{id}")
    public String updateParking(@PathVariable int id, @ModelAttribute Parking updatedParking) {
        Optional<Parking> parking = parkingService.getParkingById(id);
        parking.ifPresent(value -> {
            value.setName(updatedParking.getName());
            value.setAddress(updatedParking.getAddress());
            value.setSlotnumber(updatedParking.getSlotnumber());
            parkingService.saveParking(value);
        });
        return "redirect:/parkings";
    }

    @GetMapping("/delete/{id}")
    public String deleteParking(@PathVariable int id) {
        parkingService.deleteParking(id);
        return "redirect:/parkings";
    }


    //For booking method
    @GetMapping("/bookings/new")
    public String showBookingForm(Model model) {
        model.addAttribute("booking", new Booking());
        return "booking/booking-form";
    }

    @PostMapping("/bookings/savenew")
    public String saveBooking(@ModelAttribute Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/parkings/list";
    }

    @GetMapping("/list")
    public String getBookingList(Model model) {
        List<Booking> bookings = bookingService.getAllBookings();
        model.addAttribute("bookings", bookings);
        return "booking/booking-list";
    }

    //Delete Bookings
    @GetMapping("/deleteparking/{id}")
    public String deleteBooking(@PathVariable int id) {
//        parkingService.deleteParking(id);
        bookingService.deleteBooking(id);
        return "redirect:/parkings/list";
    }



    //Start Slots Controller
    @GetMapping("/listslot")
    public String listSlots(Model model) {
        List<Slots> slots = slotsServices.getAllSlots();
        model.addAttribute("slots", slots);
        return "slots/slots-list";
    }

    // Show form for adding a new slot
    @GetMapping("/newslot")
    public String showSlotForm(Model model) {
        model.addAttribute("slot", new Slots());
        return "slots/slot-form";
    }

    // Save a new slot
    @PostMapping("/saveslot")
    public String saveSlot(@ModelAttribute Slots slot) {
        slotsServices.saveSlot(slot);
        return "redirect:/parkings/listslot";
    }


}
