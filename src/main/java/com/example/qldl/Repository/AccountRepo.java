package com.example.qldl.Repository;

import com.example.qldl.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

    @Query(value = "SELECT UserID, Account, Pass, Email, Phone, role_id FROM Account WHERE Account = ?1", nativeQuery = true)
    Optional<AccountEntity> getAccountByTk(String accountName);
//    Optional<AccountEntity> findAccountByUserName(String userName);
    AccountEntity getAccountEntitiesByUserId(int userId);


}