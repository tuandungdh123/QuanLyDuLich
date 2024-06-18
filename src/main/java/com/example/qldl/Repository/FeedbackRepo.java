package com.example.qldl.Repository;

import com.example.qldl.Entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepo extends JpaRepository<FeedbackEntity, Integer> {
    @Query(value = "SELECT Feedback.Feedback_Id, Feedback.Comments, Account.UserID as UserID FROM Feedback INNER JOIN Account ON Feedback.UserID = Account.UserID WHERE Feedback.UserID = ?", nativeQuery = true)
    FeedbackEntity getFeedbackEntityByuserId(Integer userId);
}

