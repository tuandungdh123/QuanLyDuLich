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
@Table(name = "Book_Tour")
public class BookTourEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "Book_Tour_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookTourId;

    @Column(name = "Name_User")
    private String nameUser;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @Column(name = "Address")
    private String address;

    @Column(name = "Description")
    private String description;

    @Column(name = "Number_adults")
    private int numberAdults;

    @Column(name = "Number_Childrens")
    private int numberChildren;

    @Column(name = "Number_TreNho")
    private int numberTreNho;

    @Column(name = "Price")
    private int price;

    @Column(name = "Date_Booked")
    private LocalDateTime date_Booked;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tour_ID", referencedColumnName = "Tour_ID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private TourE tourE;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Status_ID", referencedColumnName = "Status_ID")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private StatusTourEntity statusTourEntity;
}
