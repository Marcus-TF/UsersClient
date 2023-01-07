package com.springbootcourse.http.mapper;

import com.springbootcourse.http.dto.request.role.RoleRequest;
import com.springbootcourse.http.dto.response.role.RoleResponse;
import com.springbootcourse.http.dto.response.user.UserResponse;
import com.springbootcourse.model.RoleModel;
import com.springbootcourse.model.UserModel;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RoleMapper {

    //request to model
    public static RoleModel requestToModel(RoleRequest request) {
        var response = new RoleModel();
        BeanUtils.copyProperties(request, response);
        response.setRole(request.getRoleName());

        return response;
    }


    //model to response
    public static RoleResponse modelToResponse(RoleModel roleModel) {
        var response = new RoleResponse();
        BeanUtils.copyProperties(roleModel, response);
        response.setRoleId(roleModel.getRoleId());
        response.setRoleName(roleModel.getRole());

        return response;
    }

    public static List<RoleResponse> roleResponseList(List<RoleModel> roleModelList) {
        var responseList = new ArrayList<RoleResponse>();
        responseList.addAll(roleModelList.stream().map(RoleMapper::modelToResponse).collect(Collectors.toList()));

        return responseList;
    }

    public static List<RoleModel> toModelList(List<UUID> uuidList) {
        return uuidList.stream().map(RoleMapper::createRole).collect(Collectors.toList());
    }

    public static RoleModel createRole(UUID id) {
        return RoleModel.builder()
                .roleId(id)
                .build();
    }
}
