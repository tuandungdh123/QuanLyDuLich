package com.example.qldl.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Car_Rental")
public class CarRentalEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Rental_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer rentalId;

    @Column(name = "UserID")
    private String userId;

    @Column(name = "Name_User")
    private String nameUser;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Rental_Date")
    private LocalDateTime rentalDate;

    @Column(name = "Return_Date")
    private LocalDateTime returnDate;

    @Column(name = "Total_Cost")
    private String totalCost;

    @Column(name = "Pick_Up")
    private  String pickUp;

    @Column(name = "Destination")
    private String destination;

    @Column(name = "Type_Car")
    private String typeCar;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Car_ID", referencedColumnName = "Car_ID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private CarEntity carEntity;
}
