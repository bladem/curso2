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
    @Mapping(target = "lastName", source = "lastname")
    @Mapping(target = "email", source = "email")
    @Mapping(target ="idUser", source = "id")
    User toUser(UserEntity userEntity);

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastname", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target ="id", source = "idUser")
    UserEntity toUserEntity(User user);
}
