package com.example.qldl.Entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Tour")
public class TourE {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Tour_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tourID;

    @Column(name="Tour_Name")
    private String NameTour;

    @Column(name="Images")
    private String imageTour;

    @Column(name="Duration")
    private String tourDuration;

    @Column(name="Time_Start")
    private LocalDateTime timeStart;

    @Column(name="Transport")
    private String transport;

    @Column(name="Starting_Place")
    private String startPlace;

    @Column(name="Price_Adult")
       private int priceAdult;

    @Column(name="Price_Children")
    private int priceChildren;

    @Column(name="Decription")
    private String description;

    @Column(name="Available")
    private int available;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Type_Id", referencedColumnName = "Type_Id")
    @JsonIgnoreProperties(value = {"application" ,"hibernateLazyInitializer"})
    private TypeTourE typeTourE;
}
