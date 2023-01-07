package com.springbootcourse.service.impl;

import com.springbootcourse.exceptions.DataAlreadyExistException;
import com.springbootcourse.model.UserModel;
import com.springbootcourse.repository.UserRepository;
import com.springbootcourse.service.UserService;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserModel findById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não encontrado."));
    }

    @Override
    public UserModel save(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail())){
            throw new DataAlreadyExistException("Já existe um usuário com esse email.");
        }
        return userRepository.save(userModel);
    }

    @Override
    public UserModel update(UserModel userModel, UUID uuid) {
        userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não encontrado."));
        userModel.setUserId(uuid);
        return userRepository.save(userModel);
    }

    @Override
    public UUID delete(UUID uuid) {
        var user = userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não encontrado."));
        userRepository.delete(user);
        return uuid;
    }
}
