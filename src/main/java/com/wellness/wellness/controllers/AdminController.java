package com.wellness.wellness.controllers;

import com.wellness.wellness.model.Booking;
import com.wellness.wellness.model.Client;
import com.wellness.wellness.repositories.BookingRepository;
import com.wellness.wellness.repositories.ClientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private BookingRepository bookingRepository;

    @GetMapping({"/clientedit/{id}"})
    public String clientEdit(Model model, @PathVariable (required = false) Integer id) {
        logger.info("partyEdit" + id);
        final Iterable<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("booking", bookings);
        return "admin/clientedit";
    }

    @PostMapping("/clientedit/{id}")
    public String partyEditPost(Model model, @PathVariable Integer id, @ModelAttribute("client") Client client) {
        logger.info("clientEditPost" + id);
        clientRepository.save(client);
        model.addAttribute("client", client);

        return "redirect:/client/" + id;
    }


    @ModelAttribute("client")
    public Client findClient(@PathVariable(required = false) Integer id) {
        logger.info("findClient" + id);
        if (id == null) {
            return new Client();
        }
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent())
            return optionalClient.get();
        return null;
    }

    @GetMapping({"/clientnew"})
    public String clientnew(Model model) {
        final Iterable<Booking> bookings = bookingRepository.findAll();
        model.addAttribute("bookings", bookings);
        return "admin/clientnew";
    }
    @PostMapping("/clientnew")
    public String clientNewPost(Model model,@ModelAttribute("client")Client client){
        clientRepository.save(client);
        int id = clientRepository.save(client).getId();
        return "redirect:/client/"+id;
    }


}

