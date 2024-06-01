package com.example.qldl.Repository;

import com.example.qldl.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
    @Query("select u from RoleEntity u where u.roleName like ?1")
    public List<RoleEntity> findByRoleName(String role_name);
}
