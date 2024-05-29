//package com.example.qldl.Entity;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@Entity
//@Table(name = "Book_Tour")
//public class BookTourEntity {
//    private static final long serialVersionUID = 1L;
//    @Id
//    @Column("TourID")
//    private Integer tourID;
//    @Column("Tour_Name")
//    private String tourname;
//    @Column("Full_Name")
//    private String fullName;
//    @Column("Email")
//    private String email;
//    @Column("Phone")
//    private String userAddress;
//    @Column("Notes")
//    private String notes;
//    @Column("Adult")
//    private Integer adult;
//    @Column("Children_5_11")
//    private Integer children;
//    @Column("Young_Children_2_5")
//    private Integer kid;
//    @Column("Newborn")
//    private Integer child;
//    @Column("Visa_surcharge")
//    private byte vatVisa;
//    @Column("Visa")
//    private Integer visa;
//    @Column("Single_Room_surcharge")
//    private Integer vatRoom;
//    @Column("SingleRoom")
//    private Integer singleRoom;
//    @Column("Price")
//    private Integer price;
//    @OneToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "UserID", referencedColumnName = "UserID")
//    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
//    private AccountEntity account;
//}
