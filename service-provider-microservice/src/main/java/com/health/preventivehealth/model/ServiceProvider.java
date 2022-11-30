package com.health.preventivehealth.model;

import com.health.preventivehealth.utility.ServiceProviderType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@MappedSuperclass
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String phone;
    @NotNull
    private ServiceProviderType serviceProviderType;
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    public ServiceProvider(String name, String email, String phone, ServiceProviderType serviceProviderType, Address address) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.serviceProviderType = serviceProviderType;
        this.address = address;
    }
}
