package com.cursos.curso2.application.pets;

import com.cursos.curso2.model.pets.Pet;
import com.cursos.curso2.model.pets.ports.PetRepositoryPort;
import com.cursos.curso2.model.pets.ports.PetServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetService implements PetServicePort {

    private final PetRepositoryPort petRepositoryPort;

    @Override
    public Pet createPet(String name, String type, String breed, String color, String size) {
        return null;
    }

    @Override
    public Pet updatePet(Long id, String name, String type, String breed, String color, String size) {
        return null;
    }

    @Override
    public void deletePet(Long id) {

    }

    @Override
    public Pet getPet(String name) {
        return null;
    }

    @Override
    public List<Pet> getPets() {
        return List.of();
    }
}

