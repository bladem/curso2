package com.cursos.curso2.infraestructure.adapters.users;

import com.cursos.curso2.infraestructure.jdbc.users.UserEntity;
import com.cursos.curso2.infraestructure.jdbc.users.UserMapper;
import com.cursos.curso2.infraestructure.jdbc.users.UserRepository;
import com.cursos.curso2.model.users.User;
import com.cursos.curso2.model.users.ports.UserRepositoryPort;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
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
    public User createUser(User user) {
        UserEntity userSaved = userRepository.findByName(user.getName());

        Optional.ofNullable(userSaved).ifPresent(userEntity -> {
            throw new DuplicateKeyException("User already exists");
        });

        return userMapper.toUser(userRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public User updateUser(User user) {
        userRepository.findById(user.getIdUser()).orElseThrow(() -> new EntityNotFoundException("User not found"));

        return userMapper.toUser(userRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("User not found"));

        userRepository.deleteById(id);
    }

    @Override
    public User getUser(String name) {
        UserEntity userEntity = userRepository.findByName(name);
        return Optional.ofNullable(userEntity).map(userMapper::toUser).orElse(null);
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll().stream().map(userMapper::toUser).collect(Collectors.toList());
    }
}
