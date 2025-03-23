package com.cursos.curso2.model.pets.ports;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.pets.Pet;

import java.util.List;
import java.util.Optional;

public interface PetRepositoryPort {
    Pet createPet(Pet pet);
    Pet updatePet(Pet pet);
    void deletePet(Long id);
    Pet getPet(String name);
    List<Pet> getPets();
    Optional<Pet> findByNameAndClient(String name, Client client);
}
