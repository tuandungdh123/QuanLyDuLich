package com.example.qldl.DTO;

import lombok.Data;

@Data
public class HotelDTO {
    private int hotelID;
    private String hotelName;
    private String address;
    private int rating;
    private String description;
}
