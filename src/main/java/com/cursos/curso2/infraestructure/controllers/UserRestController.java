package com.cursos.curso2.infraestructure.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cursos.curso2.model.users.dto.UserDto;
import com.cursos.curso2.model.users.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cursos.curso2.model.users.User;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
    private final UserServicePort userServicePort;

    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Pau", "Sanchez");

        return new UserDto("Hola mundo", user);
    }

    @GetMapping("/users")
    public List<User> users(){
        return userServicePort.getUsers();
    }

    @GetMapping("/user")
    public User user(){
        return userServicePort.getUser("Pau");
    }

    @GetMapping("/create")
    public Map<String, String> create(){
        userServicePort.createUser("Pau", "Sanchez");
        Map<String, String> response = new HashMap<>();
        response.put("message", "User created");
        return response;
    }
}
