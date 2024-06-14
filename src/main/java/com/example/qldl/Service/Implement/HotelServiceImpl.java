package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.HotelEntity;
import com.example.qldl.Repository.HotelRepo;
import com.example.qldl.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public List<HotelEntity> getAllHotel(){
        return hotelRepo.findAll();
    }

    @Override
    public HotelEntity getSaveHotel(HotelEntity hotelEntity){
        return hotelRepo.save(hotelEntity);
    }

    @Override
    public void doDeleteHotel(int hotelId){
        hotelRepo.deleteById(hotelId);
    }

    @Override
    public Optional<HotelEntity> getHotelByHotelId(int hotelId){
        var result = hotelRepo.getHotelEntitiesById(hotelId);
        return Optional.ofNullable(result);
    }
}
