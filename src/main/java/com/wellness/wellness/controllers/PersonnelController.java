package com.wellness.wellness.controllers;

import com.wellness.wellness.model.Client;
import com.wellness.wellness.model.Personnel;
import com.wellness.wellness.repositories.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class PersonnelController {
    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping({"/personneldetails/{id}"})
    public String personneldetails(Model model, @PathVariable(required = false) Integer id){
        if (id == null) return "personneldetails";
        Optional<Personnel> personnelFromDb = personnelRepository.findById(id);

        if (personnelFromDb.isPresent()) {
            model.addAttribute("personnel", personnelFromDb.get());
            long endOflist = personnelRepository.count();
            model.addAttribute("endOfList", endOflist);
        }
        return "personneldetails";
    }
    @GetMapping({"/personnellist"})
    public String personnellist(Model model){
        Iterable<Personnel> personnels = personnelRepository.findAll();
        model.addAttribute("personnels",personnels);
        return "personnellist";
    }

}
