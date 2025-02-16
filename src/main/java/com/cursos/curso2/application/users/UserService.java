package com.cursos.curso2.application.users;

import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserRepositoryPort;
import com.cursos.curso2.model.users.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(String name, String lastname) {
        return new User(name, lastname);
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
