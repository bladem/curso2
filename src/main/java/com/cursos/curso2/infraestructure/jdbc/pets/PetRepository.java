package com.cursos.curso2.infraestructure.jdbc.pets;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PetRepository extends CrudRepository<PetEntity, Long> {
    PetEntity findByName(String name);
}
