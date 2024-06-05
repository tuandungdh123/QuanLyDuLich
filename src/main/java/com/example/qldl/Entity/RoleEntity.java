package com.example.qldl.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "[Role]")
public class RoleEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "role_id")

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer role_id;

    @Column(name = "role_name")
    private String role_name;




}
