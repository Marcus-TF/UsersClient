package com.springbootcourse.http.controller;

import com.springbootcourse.http.dto.request.role.RoleRequest;
import com.springbootcourse.http.dto.response.role.RoleResponse;
import com.springbootcourse.http.mapper.RoleMapper;
import com.springbootcourse.service.impl.RoleServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/role")
public class RoleController {

    private final RoleServiceImpl roleService;
    @GetMapping("/findAll")
    public ResponseEntity<List<RoleResponse>> findAll(){
        var response = roleService.findAll();
        return ResponseEntity.ok().body(RoleMapper.roleResponseList(response));
    }

    @PostMapping("/create")
    public ResponseEntity<RoleResponse> save(@RequestBody RoleRequest request){
        var response = RoleMapper.requestToModel(request);
        return ResponseEntity.ok().body(RoleMapper.modelToResponse(roleService.save(response)));
    }
}
