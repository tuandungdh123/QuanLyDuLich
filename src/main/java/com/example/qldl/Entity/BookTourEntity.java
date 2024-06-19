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
    private String numberAdults;

    @Column(name = "Number_Children")
    private String numberChildren;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Tour_Id", referencedColumnName = "Tour_Id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private TourE tourE;
}
