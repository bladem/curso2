package com.cursos.curso2.model.users.dto;

import com.cursos.curso2.model.users.User;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDto {
    private String title;
    private User user;
}
