package com.example.qldl.Api;

import com.example.qldl.Entity.FeedbackEntity;
import com.example.qldl.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
@RestController


@RequestMapping("/home/feedback-api")
public class FeedbackApi {
    @Autowired
    private FeedbackService feedbackService;
    private FeedbackEntity feedbackEntity;


    @PostMapping("/submitFeedback")
    public ResponseEntity<?> submitFeedback(@RequestBody FeedbackEntity feedback) {
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Feedback submitted successfully");
            result.put("data", feedbackService.saveFeedBack(feedback));
        } catch (Exception e) {
            result.put("status", false);
            result.put("message", "Error submitting feedback");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
    @GetMapping("/getAllFeedback")
    public ResponseEntity<?> doGetAllAccount(){
        Map<String, Object> result = new HashMap<>();
        try {
            result.put("status", true);
            result.put("message", "Get All Feedback Success");
            result.put("data", feedbackService.getAllFeedback());
        } catch (Exception e){
            result.put("status", false);
            result.put("message", "Get All Feedback Fail");
            result.put("data", null);
        }
        return ResponseEntity.ok(result);
    }
}
