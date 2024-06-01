package com.example.qldl.Repository;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Integer> {

    @Query(value = "SELECT UserID, Account, Pass, Email, Phone, role_id FROM Account WHERE Account = ?1 AND Pass = ?2", nativeQuery = true)
    AccountEntity getAccountEByTkAndMk(String accountName, String Pass);
    Optional<AccountEntity> findAccountByAccountName(String accountName);

    @Query(value = "SELECT role_id, role_name FROM [Role] WHERE role_id=?1 AND role_name = ?2", nativeQuery = true)
    RoleEntity getAllByAccountName(String role_name);


    AccountEntity getAccountEntitiesByUserId(int userId);

}
