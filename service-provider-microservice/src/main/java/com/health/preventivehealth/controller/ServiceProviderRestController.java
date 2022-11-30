package com.health.preventivehealth.controller;

import com.health.preventivehealth.exception.ServiceProviderNotFoundException;
import com.health.preventivehealth.model.ServiceProvider;
import com.health.preventivehealth.service.ServiceProviderService;
import com.health.preventivehealth.utility.ServiceProviderType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ServiceProviderRestController {
    @Autowired
    private ServiceProviderService service;

    @GetMapping("/service-providers")
    public ResponseEntity<List<? extends ServiceProvider>> getAllServiceProvider(@RequestParam ServiceProviderType serviceProviderType){
        List<? extends ServiceProvider> providers = service.getAllServiceProvider(serviceProviderType);
        return ResponseEntity.ok().body(providers);
    }

    @PostMapping(value = "/service-providers")
    public ResponseEntity<ServiceProvider> createServiceProvider(@Valid @RequestBody ServiceProvider serviceProvider){
        ServiceProvider savedServiceProvider = service.saveServiceProvider(serviceProvider);
        return ResponseEntity.ok().body(savedServiceProvider);
    }

    @PutMapping(value = "/service-providers")
    public ResponseEntity<ServiceProvider> updateProvider(@Valid @RequestBody ServiceProvider serviceProvider){
        Long id = serviceProvider.getId();
        if(id == null || ! service.findServiceProvider(id, serviceProvider.getServiceProviderType()).isPresent())
            throw new ServiceProviderNotFoundException("Service Provider not found with ID: "+id);
        ServiceProvider updatedServiceProvider = service.saveServiceProvider(serviceProvider);
        return ResponseEntity.ok().body(updatedServiceProvider);
    }

    @DeleteMapping(value = "/service-providers/{id}")
    public ResponseEntity<Void> deleteServiceProvider(@PathVariable Long id, @RequestParam ServiceProviderType serviceProviderType){
        Optional<? extends ServiceProvider> serviceProvider = service.findServiceProvider(id, serviceProviderType);
        if(!serviceProvider.isPresent())
            throw new ServiceProviderNotFoundException("Service Provider not found with ID: "+id);
        service.deleteServiceProvider(id, serviceProviderType);
        return ResponseEntity.ok().build();
    }
}
