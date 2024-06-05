package com.example.qldl.Service;

import com.example.qldl.Entity.TourE;
import com.example.qldl.Entity.TypeTourE;

import java.util.List;
import java.util.Optional;

public interface TourService {
    List<TourE> getAllTour();
//    TypeTourE typeTourE (TypeTourE typeTourE);
    List<TypeTourE> getAllTypeTourE();


    TourE addTour(TourE tourE); // Phương thức thêm tour

    Optional<TourE> getTourEByTourId(Integer tourID);


    void doGetDeleteTour(Integer tourID);
}
