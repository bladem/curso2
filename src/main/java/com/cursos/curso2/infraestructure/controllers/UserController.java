package com.cursos.curso2.infraestructure.controllers;

import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/web")
@RequiredArgsConstructor
public class UserController {

    private final UserServicePort userServicePort;

    @GetMapping("/details")
    public String details(Model model){
        User user = User.builder().name("Pau").lastname("Sanchez").idUser(1L).email("bladem@gmail.com").build();
        model.addAttribute("title", "Hola mundo");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/users")
    public String users(Model model){
        model.addAttribute("title", "Lista de usuarios");
        model.addAttribute("users", this.userServicePort.getUsers());
        return "users";
    }


}
