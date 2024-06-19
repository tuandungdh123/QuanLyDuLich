package com.example.qldl.Service;

import com.example.qldl.Entity.AccountEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public interface AccountService {
    List<AccountEntity> getAllAccount();
    Optional<AccountEntity> getAccountByTkAndMk(String accountName, String password) throws SQLException;
    AccountEntity doSaveAccount(AccountEntity accountEntity);
    void  doDeleteById(int userId);
    Optional<AccountEntity> getAccountByUserId(int userId);
}