package com.springbootcourse.http.mapper;

import com.springbootcourse.http.dto.request.UserRequest;
import com.springbootcourse.http.dto.response.UserResponse;
import com.springbootcourse.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    //request to model
    public static UserModel requestToModel(UserRequest request) {
        var response = new UserModel();
        BeanUtils.copyProperties(request, response);

        return response;
    }

    //model to response
    public static UserResponse modelToResponse(UserModel userModel) {
        var response = new UserResponse();
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
