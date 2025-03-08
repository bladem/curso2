package com.cursos.curso2.infraestructure.controllers;

import java.util.List;

import com.cursos.curso2.infraestructure.mappers.UseRestMapper;
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

    private final UseRestMapper useRestMapper;

    @GetMapping("/details")
    public UserDto details(){
        User user = User.builder().name("Pau").lastname("Sanchez").build();

        return new UserDto("Hola mundo", user);
    }

    @GetMapping("/users")
    public List<UserDto> users(){
        return  this.useRestMapper.toUserDtoList(this.userServicePort.getUsers());
    }

    @GetMapping("/user")
    public UserDto user(@RequestParam("name") String name){
        return this.useRestMapper.toUserDto(this.userServicePort.getUser(name));
    }

    @PutMapping("/create")
    public ResponseEntity<UserDto> create(@RequestParam("name") String name, @RequestParam("lastname") String lastname, @RequestParam("email") String email){
        UserDto newUser = this.useRestMapper.toUserDto(this.userServicePort.createUser(name, lastname, email));
        return ResponseEntity.ok().body(newUser);
    }

    @PostMapping("/update")
    public ResponseEntity<UserDto> update(@RequestParam("id") Long id, @RequestParam("name") String name, @RequestParam("lastname") String lastname){
        UserDto updatedUser = this.useRestMapper.toUserDto(this.userServicePort.updateUser(id, name, lastname));
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id){
        this.userServicePort.deleteUser(id);
        return ResponseEntity.ok().body("User deleted");
    }
}
