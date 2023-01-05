package com.springbootcourse.http.mapper;

import com.springbootcourse.http.dto.request.UserInsertRequest;
import com.springbootcourse.http.dto.request.UserUpdateRequest;
import com.springbootcourse.http.dto.response.UserInsertResponse;
import com.springbootcourse.http.dto.response.UserResponse;
import com.springbootcourse.http.dto.response.UserUpdateResponse;
import com.springbootcourse.model.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class UserMapper {

    private final PasswordEncoder encoder;

    //request to model
    public UserModel requestInsertToModel(UserInsertRequest request) {
        var response = new UserModel();
        BeanUtils.copyProperties(request, response);
        response.setPassword(encoder.encode(request.getPassword()));

        return response;
    }

    public UserModel requestUpdateToModel(UserUpdateRequest request) {
        var response = new UserModel();
        BeanUtils.copyProperties(request, response);
        response.setPassword(encoder.encode(request.getPassword()));

        return response;
    }

    //model to response
    public static UserResponse modelToResponse(UserModel userModel) {
        var response = new UserResponse();
        BeanUtils.copyProperties(userModel, response);

        return response;
    }

    public UserInsertResponse modelToResponseInsert(UserModel userModel) {
        var response = new UserInsertResponse();
        BeanUtils.copyProperties(userModel, response);

        return response;
    }

    public UserUpdateResponse modelToResponseUpdate(UserModel userModel) {
        var response = new UserUpdateResponse();
        BeanUtils.copyProperties(userModel, response);

        return response;
    }

    //model to response list
    public static List<UserResponse> userResponseList(List<UserModel> userModelList) {
        var responseList = new ArrayList<UserResponse>();
        responseList.addAll(userModelList.stream().map(UserMapper::modelToResponse).collect(Collectors.toList()));

        return responseList;
    }
}
