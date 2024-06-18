package com.example.qldl.Repository;

import com.example.qldl.DTO.ThongKeDTO;
import com.example.qldl.Entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThongKeRepo extends JpaRepository<AccountEntity,Integer> {
//    @Query(value = "\tSELECT \n" +
//            "    ROUND(SUM(CASE WHEN role_id = 1 THEN 1 ELSE 0 END) * 100.0 / COUNT(*), 2) AS soluongRole1,\n" +
//            "    ROUND(SUM(CASE WHEN role_id = 2 THEN 1 ELSE 0 END) * 100.0 / COUNT(*), 2) AS soluongRole2\n" +
//            "FROM \n" +
//            "    Account", nativeQuery = true)
}
