package com.example.qldl.Service.Implement;


import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
    final AccountRepo repo;
    @Override
    public List<AccountEntity> getAllAccount(){
        return repo.findAll();
    };

    @Override
    public Optional<AccountEntity> getAccountByTkAndMk(String accountName, String password) throws SQLException {
        var result = repo.getAccountEByTkAndMk(accountName, password);
        return Optional.ofNullable(result);
    }
    @Override
    public void doDeleteById(int userId) {
        repo.deleteById(userId);
    }
    @Override
    public AccountEntity doSaveAccount(AccountEntity accountEntity){
        return repo.save(accountEntity);
    }

    @Override
    public Optional<AccountEntity> getAccountByUserId(int userId){
        var result = repo.getAccountEntitiesByUserId(userId);
        return Optional.ofNullable(result);
    }
}