package com.wellness.wellness.controllers;
import com.wellness.wellness.model.Booking;
import com.wellness.wellness.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    public String roomlist(Model model, @RequestParam(required = false) String keyword,@RequestParam (required = false) String roomName, @RequestParam(required = false) String date) {
       Iterable<Booking> allBooking = bookingRepository.findAllBy();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateTime = LocalDate.parse(date, formatter);
       allBooking = bookingRepository.findByfilter(keyword,roomName,dateTime);

        model.addAttribute("allbookings",allBooking);
        return "bookinglist";
    }
}
