package com.wellness.wellness.controllers;

import com.wellness.wellness.model.Booking;
import com.wellness.wellness.model.Booking;
import com.wellness.wellness.model.Room;
import com.wellness.wellness.repositories.BookingRepository;
import com.wellness.wellness.repositories.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class RoomController {
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping({"/room", "room/{id}"})
    public String room(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) {
            return "roomlist";
        }
        Optional<Room> roomFromDB = roomRepository.findById(id);
        if (roomFromDB.isPresent()) {
            model.addAttribute("room", roomFromDB);
            Iterable<Booking> allBookings =bookingRepository.findByRoom(roomFromDB);
            long endOflist = roomRepository.count();
            model.addAttribute("endOfList", endOflist);
        }
        return "room";
    }

    @GetMapping({"/roomlist"})
    public String roomlist(Model model) {
        final Iterable<Room> allRooms = roomRepository.findAll();
        model.addAttribute("allRooms",allRooms);
        return "roomlist";
    }
}
