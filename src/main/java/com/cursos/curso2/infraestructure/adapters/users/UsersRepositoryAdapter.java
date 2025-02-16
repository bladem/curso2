package com.cursos.curso2.infraestructure.adapters.users;

import com.cursos.curso2.infraestructure.jdbc.users.UserEntity;
import com.cursos.curso2.infraestructure.jdbc.users.UserMapper;
import com.cursos.curso2.infraestructure.jdbc.users.UserRepository;
import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UsersRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(String name, String lastname) {
        return userMapper.toUser(userRepository.save(UserEntity.builder().name(name).lastname(lastname).build()));
    }

    @Override
    public void updateUser(String name, String lastname) {

    }

    @Override
    public void deleteUser(String name) {

    }

    @Override
    public User getUser(String name) {
        return null;
    }

    @Override
    public List<User> getUsers() {
        return List.of();
    }
}
