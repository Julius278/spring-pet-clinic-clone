package com.julius.petclinic.controllers;

import com.julius.petclinic.model.Owner;
import com.julius.petclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@RequestMapping({"/owners"})
@Controller
public class OwnerIndexController {

    private final OwnerService ownerService;
    public OwnerIndexController(OwnerService ownerService){
        this.ownerService = ownerService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String getOwners(Model model){
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }
}
