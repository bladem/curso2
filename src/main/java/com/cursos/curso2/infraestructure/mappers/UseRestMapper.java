package com.cursos.curso2.infraestructure.mappers;

import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Mapper
public interface UseRestMapper {

    @Mapping(target = "idUser", source = "idUser")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    UserDto toUserDto(User user);

    default List<UserDto> toUserDtoList(List<User> users){
        return Optional.ofNullable(users).map(users1 -> users1.stream().map(this::toUserDto).toList()).orElse(new ArrayList<>());
    }
}
