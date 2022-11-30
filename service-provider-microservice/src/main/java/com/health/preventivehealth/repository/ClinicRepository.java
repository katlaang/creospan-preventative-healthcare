package com.health.preventivehealth.repository;

import com.health.preventivehealth.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Long> {
}
