package com.clinic.cms.repository;

import com.clinic.cms.entity.PatientDisease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientDiseaseRepository extends JpaRepository<PatientDisease, Long> {
}