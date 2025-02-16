package com.cursos.curso2.model.users.ports;

import com.cursos.curso2.model.users.User;

import java.util.List;

public interface UserRepositoryPort {
    User createUser(String name, String lastname);
    void updateUser(String name, String lastname);
    void deleteUser(String name);
    User getUser(String name);
    List<User> getUsers();
}
