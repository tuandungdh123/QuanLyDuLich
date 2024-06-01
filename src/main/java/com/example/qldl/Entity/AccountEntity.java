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
@Table(name="Account")
public class AccountEntity {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="UserID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Column(name="Account")
    private String accountName;

    @Column(name="Pass")
    private String password;

    @Column(name="Email")
    private String email;

    @Column(name="Phone")
    private String phone;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private RoleEntity role;
}
