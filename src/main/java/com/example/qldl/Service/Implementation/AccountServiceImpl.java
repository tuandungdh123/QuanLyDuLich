package com.example.qldl.Service.Implementation;


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
    public Optional<AccountEntity> getAccountByTkAndMk(String accountName, String Pass_Word) throws SQLException {
        var result = repo.getAccountEByTkAndMk(accountName, Pass_Word);
        return Optional.ofNullable(result);
    };
//    @Override
//    public Optional<AccountEntity> getAccountByAccountEntity(String accountName, String Pass_Word, String Email, String Phone, String Roles) throws SQLException; {
//        var kq = repo.getAccountByAccountEntity(accountName, Pass_Word, Email, Phone, Roles);
//        return Optional.ofNullable(result);
//    };
}
