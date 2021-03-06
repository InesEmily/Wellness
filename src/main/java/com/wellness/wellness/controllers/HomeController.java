package com.wellness.wellness.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.time.LocalDate;
import java.time.Period;

@Controller
public class HomeController {
    private Logger logger = LoggerFactory.getLogger(HomeController.class);
    @GetMapping({"/","/home"})
    public String home(Model model, Principal principal){
        final String loginName = (principal != null) ? principal.getName() : "NOBODY";
        logger.info("home logged in: "+loginName);

        return "home";
    }
    @GetMapping({"/about"})
    public String about (){
        return "about";
    }
    @GetMapping({"/tarieven"})
    public String tarieven(){
        return "tarieven";
    }
    @GetMapping({"/clientssay"})
    public String clientsSay(){
        return "clientssay";
    }
    @GetMapping({"/contact"})
    public String contact(){
        return "contact";
    }
    @GetMapping({"/publicsauna"})
    public String publicsauna(){
        return "publicsauna";
    }
    @GetMapping({"/publicwellness"})
    public String publicwellness(){
        return "publicwellness";
    }
    @GetMapping({"/viproom"})
    public String viproom(){
        return "viproom";
    }



}
