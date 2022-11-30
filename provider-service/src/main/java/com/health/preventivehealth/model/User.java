package com.health.preventivehealth.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@MappedSuperclass
public class User {
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
