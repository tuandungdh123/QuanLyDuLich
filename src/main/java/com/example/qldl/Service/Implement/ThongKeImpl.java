package com.example.qldl.Service.Implement;

import com.example.qldl.DTO.ThongKeDTO;
import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Entity.TourE;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Repository.TourRepo;
import com.example.qldl.Service.ThongKeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ThongKeImpl implements ThongKeService {
    private final AccountRepo accountRepo;
    private final TourRepo tourRepo;
    @Override
    public ThongKeDTO countRole() {
        List<AccountEntity> accounts = accountRepo.findAll();

        if (accounts.isEmpty()) {
            return new ThongKeDTO(0, 0);
        }
        long soLuongRole1 = accounts.stream()
                .filter(account -> account.getRole().getRole_id() == 1)
                .count();

        long soLuongRole2 = accounts.stream()
                .filter(account -> account.getRole().getRole_id() == 2)
                .count();

        return new ThongKeDTO(soLuongRole1, soLuongRole2);
    }

    @Override
    public ThongKeDTO countTour() {
        List<TourE> tours= tourRepo.findAll();
        if (tours.isEmpty()) {
            return new ThongKeDTO(0, 0,0,0,0);
        }
        long soLuongTour1 = tours.stream()
                .filter(tour -> tour.getTypeTourE().getType_Id() == 1)
                .count();

        long soLuongTour2 = tours.stream()
                .filter(tour -> tour.getTypeTourE().getType_Id() == 2)
                .count();

        long soLuongTour3 = tours.stream()
                .filter(tour -> tour.getTypeTourE().getType_Id() == 3)
                .count();

        long soLuongTour4 = tours.stream()
                .filter(tour -> tour.getTypeTourE().getType_Id() == 4)
                .count();

        long soLuongTour5 = tours.stream()
                .filter(tour -> tour.getTypeTourE().getType_Id() == 5)
                .count();

        return new ThongKeDTO(soLuongTour1,soLuongTour2,soLuongTour3,soLuongTour4,soLuongTour5);
    }
}
