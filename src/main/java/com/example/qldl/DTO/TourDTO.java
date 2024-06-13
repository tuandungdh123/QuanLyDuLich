package com.example.qldl.DTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TourDTO {
    private Integer tourID;
    private String NameTour;
    private Integer typeId;
    private String imageTour;
    private String typeTour;
    private String tourDuration;
    private LocalDateTime timeStart;
    private String transport;
    private String startPlace;
    private int price;
    private String description;
    private int available;
    private String experience;
}
