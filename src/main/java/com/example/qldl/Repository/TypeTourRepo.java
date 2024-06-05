package com.example.qldl.Repository;

import com.example.qldl.Entity.RoleEntity;
import com.example.qldl.Entity.TypeTourE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TypeTourRepo extends JpaRepository<TypeTourE, Integer> {
    @Query(value = "SELECT Type_Id, Type_Name FROM Type_Tour whERE Type_Tour = ?", nativeQuery = true)
    public List<TypeTourE> findByType_Name(String Type_Tour);
}
