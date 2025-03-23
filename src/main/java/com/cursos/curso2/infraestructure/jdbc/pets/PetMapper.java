package com.cursos.curso2.infraestructure.jdbc.pets;

import com.cursos.curso2.model.pets.Pet;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface PetMapper {

    @Mapping(target = "id", source = "idPet")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "breed", source = "breed")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "size", source = "size")
    PetEntity toPetEntity(Pet pet);

    @Mapping(target = "idPet", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "type", source = "type")
    @Mapping(target = "breed", source = "breed")
    @Mapping(target = "color", source = "color")
    @Mapping(target = "size", source = "size")
    Pet toPet(PetEntity petEntity);

    default List<PetEntity> toPetEntityList(List<Pet> pets){
        return pets.stream().map(this::toPetEntity).toList();
    }
}
