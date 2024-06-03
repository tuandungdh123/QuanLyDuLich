package com.example.qldl.Service;

import com.example.qldl.Entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> getAllRole();
    List<RoleEntity> getByRoleName(String role_name);
}