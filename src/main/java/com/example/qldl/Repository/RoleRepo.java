package com.example.qldl.Repository;

import com.example.qldl.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface RoleRepo extends JpaRepository<RoleEntity, Integer> {
    @Query("select u from RoleEntity u where u.role_name like ?1")
    public Optional<RoleEntity> findByRoleName(String role_name);
}
