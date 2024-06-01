package com.example.qldl.Api;

import com.example.qldl.Entity.RoleEntity;
import com.example.qldl.Repository.RoleRepo;
import com.example.qldl.Service.AccountService;
import com.example.qldl.Service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/getFindByRoleName/{role_name}")
    public List<RoleEntity> doGetFindByRoleName(@PathVariable String role_name){
        return roleService.getByRoleName(role_name);
    }
}
