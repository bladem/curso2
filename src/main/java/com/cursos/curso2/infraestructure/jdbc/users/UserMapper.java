package com.cursos.curso2.infraestructure.jdbc.users;

import com.cursos.curso2.model.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface UserMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target ="idUser", source = "id")
    User toUser(UserEntity userEntity);
}
