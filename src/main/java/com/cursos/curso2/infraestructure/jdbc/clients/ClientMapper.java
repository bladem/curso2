package com.cursos.curso2.infraestructure.jdbc.clients;

import com.cursos.curso2.infraestructure.jdbc.pets.PetMapperImpl;
import com.cursos.curso2.model.clients.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = { PetMapperImpl.class})
public interface ClientMapper {

    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "dni", source = "dni")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "pets", source = "pets")
    ClientEntity toClientEntity(Client client);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "address", source = "address")
    @Mapping(target = "city", source = "city")
    @Mapping(target = "country", source = "country")
    @Mapping(target = "postalCode", source = "postalCode")
    @Mapping(target = "dni", source = "dni")
    @Mapping(target = "birthDate", source = "birthDate")
    @Mapping(target = "pets", source = "pets")
    Client toClient(ClientEntity clientEntity);
}
