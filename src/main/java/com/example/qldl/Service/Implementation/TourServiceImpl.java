package com.example.qldl.Service.Implementation;


import com.example.qldl.Entity.TourE;
import com.example.qldl.Entity.TypeTourE;
import com.example.qldl.Repository.TourRepo;
import com.example.qldl.Repository.TypeTourRepo;
import com.example.qldl.Service.TourService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TourServiceImpl implements TourService {
    final TourRepo tourRepo;
    final TypeTourRepo typeTourRepo;

    @Override
    public List<TypeTourE> getAllTypeTourE(){
        return typeTourRepo.findAll();
    }


    @Override
    public List<TourE> getAllTour() {
        return tourRepo.findAll();
    }



    public TourE addTour(TourE tourE){
        return tourRepo.save(tourE);
    }

    @Override
    public void doGetDeleteTour(Integer tourID){
        if(tourRepo.existsById(tourID)) {
            tourRepo.deleteById(tourID);
    }else{
        throw new RuntimeException("Tour khong ton tai voi ID: " + tourID);
        }
    }

    @Override
    public Optional<TourE> getTourEByTourId(Integer tourID) {
        var result = tourRepo.getTourEByTourID(tourID);
        return Optional.ofNullable(result);
    }
}
