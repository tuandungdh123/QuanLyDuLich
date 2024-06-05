package com.example.qldl.Service.Implementation;

import com.example.qldl.Entity.CarEntity;
import com.example.qldl.Repository.CarRepo;
import com.example.qldl.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Override
    public List<CarEntity> getAllCar() {
        return carRepo.findAll();
    }
    @Override
    public CarEntity getSaveCar(CarEntity carEntity){
        return carRepo.save(carEntity);
    }
    @Override
    public void getDeleteCar(Integer carId) {
        carRepo.deleteById(carId);
    }
}
