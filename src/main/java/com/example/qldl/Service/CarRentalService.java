package com.example.qldl.Service;

import com.example.qldl.Entity.CarRentalEntity;

import java.util.List;
import java.util.Optional;

public interface CarRentalService {
    CarRentalEntity saveCarRental(CarRentalEntity carRentalEntity);
    List<CarRentalEntity> GetAllInfoCarRental();

    Optional<CarRentalEntity> getCarRentalByCarId(Integer rentalId);
}
