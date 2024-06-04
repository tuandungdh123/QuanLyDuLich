package com.example.qldl.Service;

import com.example.qldl.Entity.CarEntity;

import java.util.List;

public interface CarService {
    List<CarEntity>getAllCar();

    CarEntity getSaveCar(CarEntity carEntity);

    void getDeleteCar(Integer carId);
}
