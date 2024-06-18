package com.example.qldl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Feedback")
public class FeedbackEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "Feedback_ID")
    private int feedbackId;

    @Column(name = "Comments")
    private String comment;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name="UserID",referencedColumnName = "UserID")
    @JsonIgnoreProperties(value = {"applications","hibernateLazyInitializer"})
    private AccountEntity accountE;

}


