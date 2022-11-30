package com.health.preventivehealth.repository;

import com.health.preventivehealth.model.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
}
