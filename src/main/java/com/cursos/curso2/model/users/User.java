package com.cursos.curso2.model.users;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    private String name;
    private String lastname;
    private Long idUser;
}
