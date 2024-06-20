package com.example.qldl.Service.Implement;

import com.example.qldl.DTO.ThongKeDTO;
import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Repository.ThongKeRepo;
import com.example.qldl.Service.ThongKeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ThongKeImpl implements ThongKeService {
    private final ThongKeRepo thongKeRepo;
    @Override
    public ThongKeDTO countRole() {
        List<AccountEntity> accounts = thongKeRepo.findAll();

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
}
