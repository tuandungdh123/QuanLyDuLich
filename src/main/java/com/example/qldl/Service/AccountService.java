package com.example.qldl.Service;

import com.example.qldl.Entity.AccountEntity;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
public interface AccountService {
    List<AccountEntity> getAllAccount();
    Optional<AccountEntity> getAccountByTkAndMk(String accountName, String Pass_Word) throws SQLException;
    AccountEntity doSaveAccount(AccountEntity accountEntity);
    void  doGetDelete(int userId);
    Optional<AccountEntity> getAccountByUserId(int userId);
}