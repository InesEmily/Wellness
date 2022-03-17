package com.wellness.wellness.controllers;

import com.wellness.wellness.model.Client;
import com.wellness.wellness.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
    public String clienstlist(Model model, @RequestParam(required = false)String keyword, @RequestParam(required = false)Integer postcode, @RequestParam(required = false)String gender, @RequestParam(required = false)Integer age){
        Iterable<Client> clients;

        if (keyword != null ){
            clients = clientRepository.findAllByGender(gender.toUpperCase());
//            clients = clientRepository.findAllByPostcodeContaining(postcode);
//            clients = clientRepository.findByNameContainingIgnoreCase(keyword.toUpperCase());
        }else {
            clients = clientRepository.findAllBy();

        }
        model.addAttribute("allclient", clients);
        if (age!= null){
            ArrayList<Client> ageClients = new ArrayList<>();

            for (Client client : clientRepository.findAllBy()){
                int years = Period.between(client.getBirthday(), LocalDate.now()).getYears();

                if (years == age){
                    ageClients.add(client);
                    // hoe zet je deze arraylist dan in de view?
                    model.addAttribute("allclient",ageClients);
                }
            }
        }else {
            clients = clientRepository.findAll();
            model.addAttribute("allclient",clients);

        }

        return "clientlist";

    }


    public int calculateAge(Client client) {
        System.out.println(Period.between(client.getBirthday(), LocalDate.now()).getYears());
        return Period.between(client.getBirthday(), LocalDate.now()).getYears();
    }

}
