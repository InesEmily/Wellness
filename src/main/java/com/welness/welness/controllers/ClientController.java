package com.welness.welness.controllers;

import com.welness.welness.model.Client;
import com.welness.welness.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"/client","/client/{id}"})
    public String client(Model model, @PathVariable(required = false)Integer id){
        Optional<Client> clientFromDb = clientRepository.findById(id);

        if (clientFromDb.isPresent()) {
            model.addAttribute("client", clientFromDb.get());
        }
        return "client";
    }

}
