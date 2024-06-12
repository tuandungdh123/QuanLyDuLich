package com.example.qldl.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Hotel")
public class HotelEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Hotel_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int hotelId;

    @Column(name="Image_Hotel")
    private String imageHotel;

    @Column(name="Hotel_Name")
    private String hotelName;

    @Column(name="Address")
    private String address;

    @Column(name="Rating")
    private int rating;

    @Column(name = "Phone")
    private String phone;

    @Column(name="Description")
    private String description;

}
