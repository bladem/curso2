package com.cursos.curso2.application.pets;

import com.cursos.curso2.model.clients.Client;
import com.cursos.curso2.model.clients.ports.ClientRepositoryPort;
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
    private final ClientRepositoryPort clientRepositoryPort;


    @Override
    public Pet createPet(Pet pet, long idClient) {
        Client client = clientRepositoryPort.getClient(idClient);
        pet.setClient(client);

        return petRepositoryPort.createPet(pet);
    }

    @Override
    public Pet updatePet(Pet pet) {
        return petRepositoryPort.updatePet(pet);
    }

    @Override
    public void deletePet(Long id) {
        petRepositoryPort.deletePet(id);
    }

    @Override
    public Pet getPet(String name) {
        return petRepositoryPort.getPet(name);
    }

    @Override
    public List<Pet> getPets() {
        return petRepositoryPort.getPets();
    }
}

