package com.springbootcourse.service;

import com.springbootcourse.exceptions.DataAlreadyExistException;
import com.springbootcourse.model.UserModel;
import com.springbootcourse.repository.UserRepository;
import jakarta.persistence.NoResultException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserModel> findAll(){
        return userRepository.findAll();
    }

    public UserModel findById(UUID uuid) {
        return userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não armazenado no sistema."));
    }

    public UserModel save(UserModel userModel) {
        if (userRepository.existsByEmail(userModel.getEmail())) {
            throw new DataAlreadyExistException("Já possui um usuário com esse email no sistema.");
        }
        return userRepository.save(userModel);
    }

    public UserModel update(UserModel userModel, UUID uuid) {
        userModel = userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não armazenado no sistema."));
        userModel.setUserId(uuid);
        userRepository.save(userModel);
        return userModel;
    }

    public UUID delete(UUID uuid) {
        var response = userRepository.findById(uuid).orElseThrow(() -> new NoResultException("Usuário não armazenado no sistema."));
        userRepository.delete(response);
        return uuid;
    }
}
