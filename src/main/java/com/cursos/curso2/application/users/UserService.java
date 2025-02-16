package com.cursos.curso2.application.users;

import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserServicePort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServicePort {
    @Override
    public Optional<User> createUser(String name, String lastname) {
        return Optional.of(new User(name, lastname));
    }

    @Override
    public void updateUser(String name, String lastname) {
        System.out.println("User updated");
    }

    @Override
    public void deleteUser(String name) {
        System.out.println("User deleted");
    }

    @Override
    public User getUser(String name) {
        return new User(name, "lastname");
    }

    @Override
    public List<User> getUsers() {
        return List.of(new User("name", "lastname"));
    }
}
