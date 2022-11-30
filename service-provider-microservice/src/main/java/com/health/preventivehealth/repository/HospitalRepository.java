package com.health.preventivehealth.repository;

import com.health.preventivehealth.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospitalRepository extends JpaRepository<Hospital, Long> {
}
