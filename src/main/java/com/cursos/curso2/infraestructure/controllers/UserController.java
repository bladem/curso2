package com.cursos.curso2.infraestructure.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web")
public class UserController {

    @GetMapping("/details")
    public String details(Model model){
        model.addAttribute("title", "Hola mundo");
        model.addAttribute("name", "Pau");
        model.addAttribute("lastName", "Sanchez");
        return "details";
    }

}
