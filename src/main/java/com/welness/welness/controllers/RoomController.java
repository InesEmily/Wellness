package com.welness.welness.controllers;

import com.welness.welness.model.Room;
import com.welness.welness.repositories.RoomRepository;
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

    @GetMapping({"/room", "room/{id}"})
    public String room(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) {
            return "roomlist";
        }
        Optional<Room> roomFromDB = roomRepository.findById(id);
        if (roomFromDB.isPresent()) {
            model.addAttribute("room", roomFromDB);
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
