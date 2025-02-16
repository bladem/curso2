package com.cursos.curso2.infraestructure.jdbc.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
    UserEntity findByLastname(String lastname);
    UserEntity findByNameAndLastname(String name, String lastname);
    List<UserEntity> findAllByName(String name);
}
