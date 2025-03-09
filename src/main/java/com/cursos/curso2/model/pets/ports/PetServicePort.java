package com.cursos.curso2.model.pets.ports;

import com.cursos.curso2.model.pets.Pet;

import java.util.List;

public interface PetServicePort {
    Pet createPet(Pet pet, long idClient);
    Pet updatePet(Pet pet);
    void deletePet(Long id);
    Pet getPet(String name);
    List<Pet> getPets();
}
