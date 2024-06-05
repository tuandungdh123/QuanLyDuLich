package com.example.qldl.Api;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Repository.AccountRepo;
import com.example.qldl.Service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RestController
@RequestMapping("/account-api")
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
            result.put("data", accServ.getAllAccount());
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/login")
    public ResponseEntity<?> doGetLogin(@RequestParam("account") String account,
                                        @RequestParam("password") String password){
        Map<String, Object> result = new HashMap<>();
        try {
            var data = accServ.getAccountByTkAndMk(account, password);
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
            log.error("Fail When Call API /accountApi/login ", e);
        }
        return ResponseEntity.ok(result);
    }
    @PostMapping("/addAccount")
    public ResponseEntity<?> doPostAddAccount(@RequestBody AccountEntity accountEntity){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.doSaveAccount(accountEntity));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getAllAccount ", e);
        }
        return ResponseEntity.ok(result);
    }

    @DeleteMapping ("/DeleteId")
    public ResponseEntity<?> doDeleteUserId(@RequestParam("userId") int userId){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("success",true);
            result.put("message","Call Api Success");
            accServ.doDeleteById(userId);
        }catch(Exception e) {
            result.put("success",false);
            result.put("message","Call Api Error");
            result.put("data",null);
            System.out.println(e);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/admin/item")
    public ResponseEntity<?> doGetItem(AccountEntity account){
        Map<String, Object> kq = new HashMap<>();
        try {
            var data = accServ.getAccountByTkAndMk(account.getAccountName(), account.getPassword());
            if(!data.isEmpty()){
                kq.put("status", true);
                kq.put("message", "Login Success");
                kq.put("data", data);
            } else {
                kq.put("status", false);
                kq.put("message", "Login Fail");
            }
        } catch (Exception e){
            kq.put("status", false);
            kq.put("message", "Login Fail");
            kq.put("data", null);
            log.error("Fail When Call API /accountApi/login ", e);
        }
        return ResponseEntity.ok(kq);
    }

    @GetMapping("/getUserByUserId")
    public ResponseEntity<?> doGetUserByUserId(@RequestParam("userId") int userId){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", accServ.getAccountByUserId(userId));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
            log.error("Fail When Call API /java05/account-api/getUserByUserId ", e);
        }
        return ResponseEntity.ok(result);
    }

}