package com.health.preventivehealth.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Data
public class Provider extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(unique = true)
    private String registrationNumber;
    private String description;
    @NotBlank
    private String speciality;
    @OneToMany
    private List<ServiceProvider> serviceProvider;
}
