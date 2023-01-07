package com.springbootcourse.http.controller;

import com.springbootcourse.http.dto.message.MessageError;
import com.springbootcourse.http.dto.request.user.UserInsertRequest;
import com.springbootcourse.http.dto.request.user.UserUpdateRequest;
import com.springbootcourse.http.dto.response.user.UserInsertResponse;
import com.springbootcourse.http.dto.response.user.UserResponse;
import com.springbootcourse.http.dto.response.user.UserUpdateResponse;
import com.springbootcourse.http.mapper.UserMapper;
import com.springbootcourse.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserServiceImpl userServiceImpl;

    private final UserMapper userMapper;

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(UserMapper.userResponseList(userServiceImpl.findAll()));
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable String userId) {
        return ResponseEntity.ok().body(UserMapper.modelToResponse(userServiceImpl.findById(UUID.fromString(userId))));
    }

    @PostMapping("/create")
    public ResponseEntity<UserInsertResponse> save(@RequestBody UserInsertRequest userInsertRequest) {
        var response = userMapper.requestInsertToModel(userInsertRequest);
        return ResponseEntity.ok().body(userMapper.modelToResponseInsert(userServiceImpl.save(response)));
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<UserUpdateResponse> update(@RequestBody UserUpdateRequest request, @PathVariable String userId) {
        var response = userMapper.requestUpdateToModel(request);
        return ResponseEntity.ok().body(userMapper.modelToResponseUpdate(userServiceImpl.update(response, UUID.fromString(userId))));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<MessageError> delete(@PathVariable String userId) {
        userServiceImpl.delete(UUID.fromString(userId));
        var messageError = new MessageError();
        messageError.setMessage("Usuário deletado com sucesso!");
        messageError.setStatusCode(200);
        return ResponseEntity.ok().body(messageError);
    }
}
