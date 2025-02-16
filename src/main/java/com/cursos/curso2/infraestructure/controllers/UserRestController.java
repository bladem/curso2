package com.cursos.curso2.infraestructure.controllers;

import java.util.List;

import com.cursos.curso2.model.users.dto.UserDto;
import com.cursos.curso2.model.users.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cursos.curso2.model.users.User;


@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserRestController {
    private final UserServicePort userServicePort;

    @GetMapping("/details")
    public UserDto details(){
        User user = new User("Pau", "Sanchez", 1L);

        return new UserDto("Hola mundo", user);
    }

    @GetMapping("/users")
    public List<User> users(){
        return this.userServicePort.getUsers();
    }

    @GetMapping("/user")
    public User user(@RequestParam("name") String name){
        return this.userServicePort.getUser(name);
    }

    @PutMapping("/create")
    public ResponseEntity<User> create(@RequestParam("name") String name, @RequestParam("lastname") String lastname){
        User newUser = this.userServicePort.createUser(name, lastname);
        return ResponseEntity.ok().body(newUser);
    }

    @PostMapping("/update")
    public ResponseEntity<User> update(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("lastname") String lastname){
        User updatedUser = this.userServicePort.updateUser(id, name, lastname);
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id){
        this.userServicePort.deleteUser(id);
        return ResponseEntity.ok().body("User deleted");
    }
}
