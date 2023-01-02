package com.example.springbootcourse.repository;

import com.example.springbootcourse.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

    boolean existsByEmail(String email);
}
