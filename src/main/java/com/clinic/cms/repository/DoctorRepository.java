package com.clinic.cms.repository;

import com.clinic.cms.dto.DoctorDTO;
import com.clinic.cms.entity.Doctor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    @Query("SELECT d.id, d.name, d.specialties, d.inTime,d.outTime, d.days, d.doctorStatus FROM Doctor d")
    List<Doctor> findAllWithoutImg();
}