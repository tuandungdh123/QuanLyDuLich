package com.example.qldl.Repository;


import com.example.qldl.Entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepo extends JpaRepository <CarEntity, Integer>{

}
