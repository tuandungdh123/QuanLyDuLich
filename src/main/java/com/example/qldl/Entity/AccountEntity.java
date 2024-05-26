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
@Table(schema = "TOUR_MANAGEMENT", name="Account")
public class AccountEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="UserID")
    private Integer UserID;
    @Column(name="Account")
    private String accountName;
    @Column(name="Pass_Word")
    private String Pass_Word;
    @Column(name="Email")
    private String Email;
    @Column(name="Phone")
    private String Phone;
    @Column(name="Roles")
    private byte Roles;

//Roles
}
