package com.example.qldl.Entity;


import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Type_Tour")
public class TypeTourE {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "Type_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer type_Id;

    @Column(name = "Type_Name")
    private String type_Name;
}
