package com.wellness.wellness.controllers;

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
    public String clientEdit(Model model, @PathVariable Integer id) {
        logger.info("partyEdit" + id);

        Optional<Client> client = clientRepository.findById(id);
            model.addAttribute("client", client);
            return "/admin/clientedit";
        }

    }
//    @PostMapping("/Clientdit/{id}")
//    public String partyEditPost(Model model, @PathVariable Integer id, @ModelAttribute("party") Client client) {
//        logger.info("clientEditPost" + id);
//        clientRepository.save(client);
//        model.addAttribute("client", client);
//        return "redirect:/client/" + id;
//    }
//    @ModelAttribute("party")
//    public Client findClient(@PathVariable(required = false) Integer id) {
//        logger.info("findParty" + id);
//        if (id == null) {
//            return new Client();
//        }
//        Optional<Client> optionalClient = clientRepository.findById(id);
//        if (optionalClient.isPresent())
//            return optionalClient.get();
//        return null;
//    }



