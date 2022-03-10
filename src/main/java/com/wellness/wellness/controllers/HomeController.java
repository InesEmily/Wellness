package com.wellness.wellness.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping({"/","/home"})
    public String home(Model model){

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
