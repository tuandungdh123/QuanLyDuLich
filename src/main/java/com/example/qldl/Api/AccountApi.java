package com.example.qldl.Api;

import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RestController
@RequestMapping("/AccountRepo")
public class AccountApi {
    @Autowired
    private AccountService accServ;
    private AccountRepo roleRepo;
    @GetMapping("/getAllAccount")
    public ResponseEntity<?> doGetAllAccount(){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", roleRepo.findAll());
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/login")
    public ResponseEntity<?> doGetLogin(@RequestParam("Account") String accountName,
                                        @RequestParam("Pass_Word") String Pass_Word){
        Map<String, Object> result = new HashMap<>();
        try {
            var data = accServ.getAccountByTkAndMk(accountName, Pass_Word);
            if(!data.isEmpty()){
                result.put("status", true);
                result.put("message", "Login Success");
                result.put("data", data);
            } else {
                result.put("status", false);
                result.put("message", "Login Fail");
            }
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Login Fail");
            result.put("data", null);
            log.error("Fail When Call API /ccountaApi/login ", e);
        }
        return ResponseEntity.ok(result);
    }
}
