package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.CarRentalEntity;
import com.example.qldl.Repository.CarRentalRepo;
import com.example.qldl.Service.CarRentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarRentalServiceImpl implements CarRentalService {
    @Autowired
    private CarRentalRepo carRentalRepo;


    @Override
    public CarRentalEntity saveCarRental(CarRentalEntity carRentalEntity) {
        return carRentalRepo.save(carRentalEntity);
    }

    @Override
    public List<CarRentalEntity> GetAllInfoCarRental() {
        return carRentalRepo.findAll();
    }

    @Override
    public Optional<CarRentalEntity> getCarRentalByCarId(Integer rentalId) {
        var result = carRentalRepo.getCarRentalByCarId(rentalId);
        return Optional.ofNullable(result);
    }

}
