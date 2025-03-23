package com.cursos.curso2.model.users.ports;

import com.cursos.curso2.model.users.User;

import java.util.List;

public interface UserServicePort {
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(Long id);
    User getUser(String name);
    List<User> getUsers();
}
