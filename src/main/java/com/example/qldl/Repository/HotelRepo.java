package com.example.qldl.Repository;

import com.example.qldl.Entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface HotelRepo extends JpaRepository<HotelEntity, Integer> {
    @Query(value = "SELECT Hotel_Id, Image_Hotel, Hotel_Name, Address, Rating, Phone, Description FROM Hotel where Hotel_Id=?1", nativeQuery = true)
    HotelEntity getHotelEntitiesById(int hotelId);
}
