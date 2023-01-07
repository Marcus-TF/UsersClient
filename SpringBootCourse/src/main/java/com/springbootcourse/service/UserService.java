package com.springbootcourse.service;

import com.springbootcourse.model.UserModel;

import java.util.List;
import java.util.UUID;

public interface UserService {

    List<UserModel> findAll();

    UserModel findById(UUID uuid);

    UserModel save(UserModel userModel);

    UserModel update(UserModel userModel, UUID uuid);

    UUID delete(UUID uuid);
}
