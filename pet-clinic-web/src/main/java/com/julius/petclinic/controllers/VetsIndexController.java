package com.julius.petclinic.controllers;

import com.julius.petclinic.services.VetService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping({"/vets", "/vets.html"})
@Controller
public class VetsIndexController {

    private final VetService vetService;

    public VetsIndexController(VetService vetService){
        this.vetService = vetService;
    }
    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getVets(Model model){
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }
}
