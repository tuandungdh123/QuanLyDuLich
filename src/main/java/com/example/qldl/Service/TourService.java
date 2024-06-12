package com.example.qldl.Service;

import com.example.qldl.Entity.TourE;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<TourE> getAllTour();


    TourE addTour(TourE tourE); // Phương thức thêm tour

//    List<TourE> getToursByTypeId(Integer type_Id);

    Optional<TourE> getTourEByTourId(Integer tourID);

    void doGetDeleteTour(Integer tourID);


    List<TourE> getToursByTypeId(Integer type_ID);
}
