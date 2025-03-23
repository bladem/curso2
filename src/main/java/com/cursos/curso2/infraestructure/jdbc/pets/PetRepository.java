package com.cursos.curso2.infraestructure.jdbc.pets;

import com.cursos.curso2.model.clients.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PetRepository extends JpaRepository<PetEntity, Long> {
    Optional<PetEntity> findByName(String name);
    Optional<PetEntity> findByNameAndClient(String name, Client client);
}
