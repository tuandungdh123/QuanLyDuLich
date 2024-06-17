//package com.example.qldl.Api;
//
//import com.example.qldl.Entity.mailE;
//import com.example.qldl.Service.mailService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/sendmail-api")
//public class mailApi {
//    @PostMapping("/sendmail")
//    public Map<?,?> doPostSendMail(){
//        var result = new HashMap<String, Object>();
//        try{
//            mailService.sendMail(new mailE());
//            result.put("success", true);
//        } catch (Exception e) {
//            result.put("success", false);
//            throw new RuntimeException(e);
//        }
//        return result;
//    }
//}
