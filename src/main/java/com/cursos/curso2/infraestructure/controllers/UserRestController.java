package com.cursos.curso2.infraestructure.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.curso2.model.User;


@RestController
@RequestMapping("/api")
public class UserRestController {

    @GetMapping("/details")
    public Map<String, Object>details(){
        User user = new User("Pau", "Sanchez");

        Map<String, Object> model = new HashMap<>();
        model.put("title", "Hola mundo");
        model.put("user", user);
        return model;
    }

}
