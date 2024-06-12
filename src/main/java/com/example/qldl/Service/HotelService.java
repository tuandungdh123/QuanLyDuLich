package com.example.qldl.Service;

import com.example.qldl.Entity.HotelEntity;

import java.util.List;
import java.util.Optional;

public interface HotelService {
    List<HotelEntity> getAllHotel();

    HotelEntity getSaveHotel(HotelEntity hotelEntity);

    void doDeleteHotel(int hotelId);

    Optional<HotelEntity> getHotelByHotelId(int hotelId);
}
