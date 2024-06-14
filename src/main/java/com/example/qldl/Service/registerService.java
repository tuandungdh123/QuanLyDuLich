package com.example.qldl.Service;

import com.example.qldl.Entity.AccountEntity;

public interface registerService {
    AccountEntity doSaveAccount(AccountEntity accountEntity) throws Exception;
}
