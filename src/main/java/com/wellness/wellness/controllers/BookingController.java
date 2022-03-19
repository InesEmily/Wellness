package com.wellness.wellness.controllers;
import com.wellness.wellness.model.Booking;
import com.wellness.wellness.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping({"/booking/{id}","/booking"})
    public String booking(Model model, @PathVariable (required = false)Integer id){
        if (id == null) {
            return "booking";
        }
        Optional<Booking> bookingFromDB = bookingRepository.findById(id);
        if (bookingFromDB.isPresent()) {
            model.addAttribute("booking", bookingFromDB);
            long endOflist = bookingRepository.count();
            model.addAttribute("endOfList", endOflist);
        }
        return "booking";
    }
    @GetMapping({"/bookinglist"})
    public String roomlist(Model model) {
        final Iterable<Booking> allBooking = bookingRepository.findAll();
        model.addAttribute("allbookings",allBooking);
        return "bookinglist";
    }
}
