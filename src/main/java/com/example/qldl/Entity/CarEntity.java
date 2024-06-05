package com.example.qldl.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class CarEntity {
    @Id
    @Column(name = "Car_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "Image_Car")
    private String imageCar;

    @Column(name = "Type_Car")
    private String typeCar;

    @Column(name = "Number_Seats")
    private int numberSeat;

    @Column(name = "Price")
    private int price;

    @Column(name = "Color")
    private String color;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Availability")
    private byte availability;

    @Column(name = "Description")
    private String description;

}
