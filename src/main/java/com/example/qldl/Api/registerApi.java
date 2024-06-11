package com.example.qldl.Api;

import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Service.registerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@Controller
@RequestMapping("/register-api")
public class registerApi {
    @Autowired
    private registerService accServ;
    @PostMapping ("/register")
    public ResponseEntity<?> doPostRegister(@RequestBody AccountEntity accountEntity){
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
}
