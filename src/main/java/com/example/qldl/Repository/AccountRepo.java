package com.example.qldl.Repository;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

    @Query(value = "SELECT UserID, Username, Pass, Email, Phone, role_id FROM Account WHERE Username = ?1 AND Pass = ?2", nativeQuery = true)
    AccountEntity getAccountEByTkAndMk(String Username, String Pass);
    Optional<AccountEntity> findAccountByUserName(String userName);
    AccountEntity getAccountEntitiesByUserId(int userId);
}