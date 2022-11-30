package com.health.preventivehealth.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotNull
    @Column(unique = true)
    private String userName;
    @NotNull
    @Column(unique = true)
    private String email;
    private String password;
    private String phone;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
}
