package com.julius.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OwnerIndexController {

    @RequestMapping("owners")
    public String getOwners(){
        return "owners/index";
    }
}
