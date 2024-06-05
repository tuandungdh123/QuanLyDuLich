package com.example.qldl.Api;

import com.example.qldl.Entity.RoleEntity;
import com.example.qldl.Repository.RoleRepo;
import com.example.qldl.Service.AccountService;
import com.example.qldl.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/role-api")
public class RoleApi {
    @Autowired
    private RoleService roleService;
    @GetMapping("/getAllRole")
    public ResponseEntity<?> doGetAllRole(){
        Map<String, Object> result = new HashMap<>();
        result.put("success",true);
        result.put("message","Call Api Success");
        result.put("data",roleService.getAllRole());
        return ResponseEntity.ok(result);

    }
    @GetMapping("/getFindByRoleName")
    public ResponseEntity<?> doGetFindByRoleName(@RequestParam("role_Name") String role_name ){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Account Success");
            result.put("data", roleService.getRoleByRoleName(role_name));
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Account Fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}