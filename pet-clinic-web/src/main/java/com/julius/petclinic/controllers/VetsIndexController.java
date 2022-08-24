package com.julius.petclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VetsIndexController {

    @RequestMapping("vets")
    public String getVets(){
        return "vets/index";
    }
}
