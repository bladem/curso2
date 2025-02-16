package com.cursos.curso2.model.pets.ports;

import com.cursos.curso2.model.pets.Pet;

import java.util.List;

public interface PetServicePort {
    Pet createPet(String name, String type, String breed, String color, String size);
    Pet updatePet(Long id, String name, String type, String breed, String color, String size);
    void deletePet(Long id);
    Pet getPet(String name);
    List<Pet> getPets();
}
