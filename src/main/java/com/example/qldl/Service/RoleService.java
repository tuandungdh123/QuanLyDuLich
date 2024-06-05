package com.example.qldl.Service;

import com.example.qldl.Entity.RoleEntity;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    List<RoleEntity> getAllRole();
    Optional<RoleEntity> getRoleByRoleName(String role_name);
}
