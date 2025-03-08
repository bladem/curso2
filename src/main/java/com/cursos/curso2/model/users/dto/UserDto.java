package com.cursos.curso2.model.users.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String title;
    private String name;
    private String lastName;
    private String email;
    private Long idUser;
}
