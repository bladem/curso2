package com.cursos.curso2.infraestructure.jdbc.users;

import com.cursos.curso2.model.users.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastname", source = "lastname")
    User toUser(UserEntity userEntity);
}
