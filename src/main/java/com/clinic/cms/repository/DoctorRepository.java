package com.clinic.cms.repository;

import com.clinic.cms.entity.Doctor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
