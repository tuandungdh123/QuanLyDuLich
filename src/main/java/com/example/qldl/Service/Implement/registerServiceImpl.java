package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Repository.RoleRepo;
import com.example.qldl.Service.registerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class registerServiceImpl implements registerService {
    final AccountRepo repo;
    final RoleRepo roleRepo;
    @Override
    public AccountEntity doSaveAccount(AccountEntity accountEntity) {
//        Optional<RoleEntity> defaultRole = roleRepo.findByRoleName("User");
//        accountEntity.getRole().add(defaultRole);
        return repo.save(accountEntity);
    }
}
