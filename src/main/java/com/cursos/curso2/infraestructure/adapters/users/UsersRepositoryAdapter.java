package com.cursos.curso2.infraestructure.adapters.users;

import com.cursos.curso2.infraestructure.jdbc.users.UserEntity;
import com.cursos.curso2.infraestructure.jdbc.users.UserMapper;
import com.cursos.curso2.infraestructure.jdbc.users.UserRepository;
import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UsersRepositoryAdapter implements UserRepositoryPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User createUser(String name, String lastname) {
        UserEntity user = userRepository.findByName(name);

        Optional.ofNullable(user).ifPresent(userEntity -> {
            throw new DuplicateKeyException("User already exists");
        });

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
        UserEntity userEntity = userRepository.findByName(name);
        return Optional.ofNullable(userEntity).map(userMapper::toUser).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        List<UserEntity> users = (List<UserEntity>) userRepository.findAll();

        return users.stream().map(userMapper::toUser).collect(Collectors.toList());
    }
}
