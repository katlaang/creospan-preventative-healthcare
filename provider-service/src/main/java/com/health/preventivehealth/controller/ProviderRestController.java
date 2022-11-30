package com.health.preventivehealth.controller;

import com.health.preventivehealth.exception.ProviderNotFoundException;
import com.health.preventivehealth.model.Provider;
import com.health.preventivehealth.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProviderRestController {
    @Autowired
    private ProviderRepository repository;

    @GetMapping("/providers")
    public ResponseEntity<List<Provider>> getAllProvider(){
        List<Provider> providers = repository.findAll();
        return ResponseEntity.ok().body(providers);
    }

    @GetMapping(value = "/providers/{id}")
    public ResponseEntity<Provider> getProvider(@PathVariable Long id){
        Optional<Provider> provider = repository.findById(id);
        if(!provider.isPresent())
            throw new ProviderNotFoundException("Provider not found with ID: "+id);
        return ResponseEntity.ok().body(provider.get());
    }

    @PutMapping(value = "/providers")
    public ResponseEntity<Provider> updateProvider(@Valid @RequestBody Provider provider){
        Long id = provider.getId();
        if(id == null || ! repository.findById(id).isPresent())
            throw new ProviderNotFoundException("Provider not found with ID: "+id);
        Provider updatedProvider = repository.save(provider);
        return ResponseEntity.ok().body(updatedProvider);
    }

    @DeleteMapping(value = "/providers/{id}")
    public ResponseEntity<Void> deleteProvider(@PathVariable Long id){
        Optional<Provider> provider = repository.findById(id);
        if(!provider.isPresent())
            throw new ProviderNotFoundException("Provider not found with ID: "+id);
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/providers")
    public ResponseEntity<Provider> createProvider(@Valid @RequestBody Provider provider){
        Provider savedProvider = repository.save(provider);
        return ResponseEntity.ok().body(savedProvider);
    }
}
