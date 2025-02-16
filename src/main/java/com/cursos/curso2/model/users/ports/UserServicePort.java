package com.cursos.curso2.model.users.ports;

import com.cursos.curso2.model.users.User;

import java.util.List;

public interface UserServicePort {
    User createUser(String name, String lastname, String email);
    User updateUser(Long id, String name, String lastname);
    void deleteUser(Long id);
    User getUser(String name);
    List<User> getUsers();
}
