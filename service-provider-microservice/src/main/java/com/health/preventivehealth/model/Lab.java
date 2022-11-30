package com.health.preventivehealth.model;

import com.health.preventivehealth.utility.ServiceProviderType;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
public class Lab extends ServiceProvider{
    public Lab(String name, String email, String phone, ServiceProviderType type, Address address) {
        super(name, email, phone, type, address);
    }
}
