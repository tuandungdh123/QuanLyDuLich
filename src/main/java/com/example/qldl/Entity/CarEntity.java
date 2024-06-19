package com.example.qldl.Entity;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;
import org.aspectj.weaver.GeneratedReferenceTypeDelegate;

import java.io.Serializable;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Car")
public class CarEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Car_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int carId;

    @Column(name = "Image_Car")
    private String imageCar;

    @Column(name = "Car_Model")
    private String carModel;

    @Column(name = "Car_Manufacturer")
    private String carManufacturer;

    @Column(name = "Number_Seats")
    private int numberSeat;

    @Column(name = "Color")
    private String color;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Description")
    private String description;

    @JsonCreator
    public CarEntity(@JsonProperty("carId") int carId) {
        this.carId = carId;
    }

}
