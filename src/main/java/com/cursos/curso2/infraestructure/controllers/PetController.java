package com.cursos.curso2.infraestructure.controllers;

import com.cursos.curso2.model.pets.Pet;
import com.cursos.curso2.model.pets.ports.PetServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pet")
@RequiredArgsConstructor
public class PetController {

    private final PetServicePort petServicePort;

    @PostMapping("/create")
    public Pet createPet(@RequestParam("name") String name, @RequestParam("breed") String breed,
                         @RequestParam("color") String color, @RequestParam("size") String size,
                         @RequestParam("type") String type, @RequestParam("idClient") Long idClient) {
        Pet pet = Pet.builder().name(name).breed(breed).color(color).size(size).type(type).build();

        return petServicePort.createPet(pet, idClient);
    }

    @PutMapping("/update")
    public Pet updatePet(@RequestParam("id") Long id, @RequestParam("name") String name,
                         @RequestParam("breed") String breed, @RequestParam("color") String color,
                         @RequestParam("size") String size, @RequestParam("type") String type ) {
        Pet pet = Pet.builder().idPet(id).name(name).breed(breed).color(color).size(size).type(type).build();
        return petServicePort.updatePet(pet);
    }

    @DeleteMapping("/delete")
    public void deletePet(@RequestParam("id") Long id) {
        petServicePort.deletePet(id);
    }

    @GetMapping("/getPet")
    public Pet getPet(@RequestParam("name") String name) {
        return petServicePort.getPet(name);
    }

    @GetMapping("/getPets")
    public List<Pet> getPets() {
        return petServicePort.getPets();
    }
}
