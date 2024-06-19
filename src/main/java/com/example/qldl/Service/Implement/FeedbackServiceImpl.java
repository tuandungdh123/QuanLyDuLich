package com.example.qldl.Service.Implement;

import com.example.qldl.Entity.FeedbackEntity;
import com.example.qldl.Repository.FeedbackRepo;
import com.example.qldl.Service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class FeedbackServiceImpl implements FeedbackService {
    @Autowired
    private FeedbackRepo feedbackRepo;

    @Override
    public List<FeedbackEntity> getAllFeedback(){ return feedbackRepo.findAll();}

    @Override
    public FeedbackEntity saveFeedBack(FeedbackEntity feedbackEntity){
        return feedbackRepo.save(feedbackEntity);
        }
    }

