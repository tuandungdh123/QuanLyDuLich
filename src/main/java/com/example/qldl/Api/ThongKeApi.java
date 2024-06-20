package com.example.qldl.Api;

import com.example.qldl.DTO.ThongKeDTO;
import com.example.qldl.Entity.AccountEntity;
import com.example.qldl.Service.ThongKeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping("/thongke-api")
@RequiredArgsConstructor
public class ThongKeApi {
    private final ThongKeService thongkeService;
    @GetMapping("/getCountRole")
    public ResponseEntity<?> getCountRole() {
        HashMap<String,Object> result = new HashMap<>();
        try {
            ThongKeDTO thongKeDTO= thongkeService.countRole();
            result.put("success",true);
            result.put("message","Call Api success");
            result.put("data", thongKeDTO);
        }catch (Exception e){
            result.put("success",false);
            result.put("message","Call Api fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}
