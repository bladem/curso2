package com.cursos.curso2.infraestructure.adapters.pet;

import com.cursos.curso2.infraestructure.jdbc.pets.PetEntity;
import com.cursos.curso2.infraestructure.jdbc.pets.PetMapper;
import com.cursos.curso2.infraestructure.jdbc.pets.PetRepository;
import com.cursos.curso2.model.pets.Pet;
import com.cursos.curso2.model.pets.ports.PetRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class PetRepositoryAdapter implements PetRepositoryPort {

    private final PetRepository petRepository;
    private final PetMapper petMapper;

    @Override
    public Pet createPet(Pet pet) {
        return this.petMapper.toPet(this.petRepository.save(this.petMapper.toPetEntity(pet)));
    }

    @Override
    public Pet updatePet(Pet pet) {
        this.petRepository.findById(pet.getIdPet()).orElseThrow(()-> new EntityNotFoundException("Pet not found"));
        return this.petMapper.toPet(this.petRepository.save(this.petMapper.toPetEntity(pet)));
    }

    @Override
    public void deletePet(Long id) {
        this.petRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Pet not found"));
        this.petRepository.deleteById(id);
    }

    @Override
    public Pet getPet(String name) {
        PetEntity petEntity = this.petRepository.findByName(name);
        return Optional.ofNullable(petEntity).map(this.petMapper::toPet).orElse(null);
    }

    @Override
    public List<Pet> getPets() {
        return this.petRepository.findAll().stream().map(this.petMapper::toPet).toList();
    }
}
