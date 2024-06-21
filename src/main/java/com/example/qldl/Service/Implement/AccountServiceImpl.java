package com.example.qldl.Service.Implement;


import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Service.AccountService;
import com.example.qldl.exception.AppException;
import com.example.qldl.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    public Optional<AccountEntity> getAccountByTk(String accountName) throws SQLException, AppException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        var user = repo.getAccountByTk(accountName).orElseThrow(() -> new AppException(ErrorCode.USER_NOT_EXISTED));
        boolean authenticated = passwordEncoder.matches(user.getPassword(), user.getPassword());
        return Optional.ofNullable(user);
    }
    @Override
    public void doDeleteById(int userId) {
        repo.deleteById(userId);
    }
    @Override
    public AccountEntity doSaveAccount(AccountEntity accountEntity){
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        accountEntity.setPassword(passwordEncoder.encode(accountEntity.getPassword()));
        return repo.save(accountEntity);
    }

    @Override
    public Optional<AccountEntity> getAccountByUserId(int userId){
        var result = repo.getAccountEntitiesByUserId(userId);
        return Optional.ofNullable(result);
    }
}