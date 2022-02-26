package com.welness.welness.controllers;

import com.welness.welness.model.Client;
import com.welness.welness.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"/client","/client/{id}"})
    public String client(Model model, @PathVariable(required = false)Integer id){
        if (id == null) return "client";
        Optional<Client> clientFromDb = clientRepository.findById(id);

        if (clientFromDb.isPresent()) {
            model.addAttribute("client", clientFromDb.get());
            long endOflist = clientRepository.count();
            model.addAttribute("endOfList",endOflist);
        }
        return "client";
    }
    @GetMapping({"/clientlist"})
    public String clienstlist(Model model){
        final Iterable<Client> allClient = clientRepository.findAll();
        model.addAttribute("allclient", allClient);
        return "clientlist";
    }

}
