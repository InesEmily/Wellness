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
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping({"/client", "/client/{id}"})
    public String client(Model model, @PathVariable(required = false) Integer id) {
        if (id == null) return "client";
        Optional<Client> clientFromDb = clientRepository.findById(id);

        if (clientFromDb.isPresent()) {
            model.addAttribute("client", clientFromDb.get());
            long endOflist = clientRepository.count();
            model.addAttribute("endOfList", endOflist);
        }
        return "client";
    }

    @GetMapping({"/clientlist"})
    public String clienstlist(Model model, @RequestParam(required = false) String keyword, @RequestParam(required = false) Integer postcode, @RequestParam(required = false) String gender, @RequestParam(required = false) Integer age) {
        Iterable<Client> clients;
        ArrayList<Client> Clientlist = new ArrayList<>();
        ArrayList<Client> ClientlistFiltered = new ArrayList<>();

        clients = clientRepository.findByfilter(keyword, postcode, gender);

        if (gender != null) {
            clients = clientRepository.findAllByGender(gender.toUpperCase());
            for(Client client : Clientlist){
                if(Clientlist.contains(client))
                ClientlistFiltered.add(client);
            }
        }

        if (postcode != null) {
            for(Client client : Clientlist){
                if(!Clientlist.contains(client)){
                    ClientlistFiltered.add(client);
                }
            }
            Clientlist.addAll(clientRepository.findAllByPostcodeContaining(postcode));
        }
        if (keyword != null) {
            Clientlist.addAll(clientRepository.findByNameContainingIgnoreCase(keyword.toUpperCase()));
        }
        if (age != null) {
            for (Client client : clientRepository.findAllBy()) {
                int years = Period.between(client.getBirthday(), LocalDate.now()).getYears();
                if (years == age) {
                    Clientlist.add(client);
                }
            }
        }
        model.addAttribute("allclient",Clientlist);
        return "clientlist";

    }


    public int calculateAge(Client client) {
        System.out.println(Period.between(client.getBirthday(), LocalDate.now()).getYears());
        return Period.between(client.getBirthday(), LocalDate.now()).getYears();
    }

}
