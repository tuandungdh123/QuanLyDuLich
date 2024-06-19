package com.example.qldl.Repository;

import com.example.qldl.Entity.CarRentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRentalRepo extends JpaRepository<CarRentalEntity, Integer> {
    @Query(value = "SELECT Car_Rental.Rental_Id, Car_Rental.Car_Id, Car_Rental.UserId, Car_Rental.Rental_Date, Car_Rental.Return_Date, Car_Rental.Total_Cost, Car_Rental.Pick_Up, Car_Rental.Destination, Car_Rental.Name_User, Car_Rental.Phone, Car_Rental.Email, Car_Rental.Description, Car_Rental.Type_Car\n" +
            "\t\tFROM Car_Rental inner join Car on Car_Rental.Car_ID = Car.Car_ID \n" +
            "\t\tWHERE Car_Rental.Car_ID = ?", nativeQuery = true)
    CarRentalEntity getCarRentalByCarId(Integer rentalId);
}
