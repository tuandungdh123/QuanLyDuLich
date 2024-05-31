package com.example.qldl.Service.Implementation;


import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Entity.RoleEntity;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Repository.RoleRepo;
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
    final RoleRepo rolerepo;

    @Override
    public List<AccountEntity> getAllAccount(){
        return repo.findAll();
    };

    @Override
    public Optional<AccountEntity> getAccountByTkAndMk(String accountName, String Pass_Word) throws SQLException {
        var result = repo.getAccountEByTkAndMk(accountName, Pass_Word);
        return Optional.ofNullable(result);
    }

    @Override
    public AccountEntity account(AccountEntity account) {
        return null;
    }

    @Override
    public Object save() {
        return null;
    }

    ;
    public AccountEntity addAccount(AccountEntity account){
        return repo.save(account);
    }
    @Override
    public List<RoleEntity> getAllRole(){
        return rolerepo.findAll();
    }
}
