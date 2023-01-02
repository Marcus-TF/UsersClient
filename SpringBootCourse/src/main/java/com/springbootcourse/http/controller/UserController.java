package com.springbootcourse.http.controller;

import com.springbootcourse.http.dto.message.MessageError;
import com.springbootcourse.http.dto.request.UserRequest;
import com.springbootcourse.http.dto.response.UserResponse;
import com.springbootcourse.http.mapper.UserMapper;
import com.springbootcourse.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/findAll")
    public ResponseEntity<List<UserResponse>> findAll() {
        return ResponseEntity.ok().body(UserMapper.userResponseList(userService.findAll()));
    }

    @GetMapping("/findById/{userId}")
    public ResponseEntity<UserResponse> findById(@PathVariable String userId) {
        return ResponseEntity.ok().body(UserMapper.modelToResponse(userService.findById(UUID.fromString(userId))));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponse> save(@RequestBody UserRequest userRequest) {
        var response = UserMapper.requestToModel(userRequest);
        return ResponseEntity.ok().body(UserMapper.modelToResponse(userService.save(response)));
    }

    @PutMapping("/update/{userId}")
     public ResponseEntity<UserResponse> update(@RequestBody UserRequest request, @PathVariable String userId) {
        var response = UserMapper.requestToModel(request);
        return ResponseEntity.ok().body(UserMapper.modelToResponse(userService.update(response, UUID.fromString(userId))));
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<MessageError> delete(@PathVariable String userId) {
        var response = userService.delete(UUID.fromString(userId));
        var messageError = new MessageError();
        messageError.setMessage("Usuário deletado com sucesso!");
        messageError.setErrorCode(200);
        return ResponseEntity.ok().body(messageError);
    }
}
