package com.example.qldl.Repository;

import com.example.qldl.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

    @Query(value = "SELECT UserID, Account, Pass_Word, Email, Phone, Roles FROM Account WHERE Account = ?1 AND Pass_Word = ?2", nativeQuery = true)
    AccountEntity getAccountEByTkAndMk(String accountName, String Pass_Word);
    Optional<AccountEntity> findAccountByAccountName(String accountName);

}
