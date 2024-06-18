package com.example.qldl.Service;

import com.example.qldl.Entity.FeedbackEntity;

import java.util.List;

public interface FeedbackService {

    List<FeedbackEntity> getAllFeedback();

    FeedbackEntity saveFeedBack(FeedbackEntity feedbackEntity);
}
