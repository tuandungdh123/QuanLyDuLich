package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Entity.mailE;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Repository.RoleRepo;
import com.example.qldl.Service.mailService;
import com.example.qldl.Service.registerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class registerServiceImpl implements registerService {
    final AccountRepo repo;
    final RoleRepo roleRepo;
    final mailService mailService;
    @Override
    public AccountEntity doSaveAccount(AccountEntity accountEntity) throws Exception {
        mailE mail = new mailE();
        mail.setTo(accountEntity.getEmail());
        mailService.sendMail(mail);
        return repo.save(accountEntity);
    }
}
