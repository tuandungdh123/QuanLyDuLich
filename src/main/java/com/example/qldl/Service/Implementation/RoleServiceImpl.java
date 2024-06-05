package com.example.qldl.Service.Implementation;

import com.example.qldl.Entity.RoleEntity;
import com.example.qldl.Repository.RoleRepo;
import com.example.qldl.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepo roleRepository;
    @Override
    public List<RoleEntity> getAllRole() {
        return roleRepository.findAll() ;
    }
    @Override
    public Optional<RoleEntity> getRoleByRoleName(String role_name){
        var result = roleRepository.findByRoleName(role_name);
        return result;
    };
}
