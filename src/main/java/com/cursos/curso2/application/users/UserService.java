package com.cursos.curso2.application.users;

import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserRepositoryPort;
import com.cursos.curso2.model.users.ports.UserServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserServicePort {
    private final UserRepositoryPort userRepositoryPort;

    @Override
    public User createUser(User user) {
        return userRepositoryPort.createUser(user);
    }

    @Override
    public User updateUser(User user) {
       return userRepositoryPort.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepositoryPort.deleteUser(id);
    }

    @Override
    public User getUser(String name) {
        return userRepositoryPort.getUser(name);
    }

    @Override
    public List<User> getUsers() {
        return userRepositoryPort.getUsers();
    }
}
