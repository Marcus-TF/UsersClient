package com.springbootcourse.service.impl;

import com.springbootcourse.model.RoleModel;
import com.springbootcourse.repository.RoleRepository;
import com.springbootcourse.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;


    @Override
    public RoleModel save(RoleModel roleModel) {
        return roleRepository.save(roleModel);
    }

    @Override
    public List<RoleModel> findAll() {
        return roleRepository.findAll();
    }
}
