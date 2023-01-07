package com.springbootcourse.service;

import com.springbootcourse.model.RoleModel;

import java.util.List;

public interface RoleService {

    RoleModel save(RoleModel roleModel);

    List<RoleModel> findAll();
}
