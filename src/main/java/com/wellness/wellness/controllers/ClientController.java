package com.wellness.wellness.controllers;

import com.wellness.wellness.model.Client;
import com.wellness.wellness.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Locale;
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
    public String clienstlist(Model model, @RequestParam(required = false)String keyword){
        List<Client> clients;
        if (keyword != null){
            clients = clientRepository.findByNameContainingIgnoreCase(keyword.toUpperCase());
        }else {
            clients = clientRepository.findAllBy();
        }
        model.addAttribute("allclient", clients);
        return "clientlist";
    }

}
