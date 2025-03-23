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
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserRestController {
    private final UserServicePort userServicePort;

    private final UseRestMapper useRestMapper;

    @GetMapping("/details")
    public UserDto details(){
        User user = User.builder().name("Pau").lastName("Sanchez").build();

        return this.useRestMapper.toUserDto(user);
    }

    @GetMapping("/users")
    public List<UserDto> users(){
        return  this.useRestMapper.toUserDtoList(this.userServicePort.getUsers());
    }

    @GetMapping("/getUserByName")
    public UserDto user(@RequestParam("name") String name){
        return this.useRestMapper.toUserDto(this.userServicePort.getUser(name));
    }

    @PostMapping("/create")
    public ResponseEntity<UserDto> create(@RequestBody UserDto userDto){
        UserDto newUser = this.useRestMapper.toUserDto(this.userServicePort.createUser(this.useRestMapper.toUser(userDto)));
        return ResponseEntity.ok().body(newUser);
    }

    @PutMapping("/update")
    public ResponseEntity<UserDto> update(@RequestBody UserDto userDto){
        UserDto updatedUser = this.useRestMapper.toUserDto(this.userServicePort.updateUser(this.useRestMapper.toUser(userDto)));
        return ResponseEntity.ok().body(updatedUser);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam("id") Long id){
        this.userServicePort.deleteUser(id);
        return ResponseEntity.ok().body("User deleted");
    }
}
