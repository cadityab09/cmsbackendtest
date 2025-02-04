package com.clinic.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.clinic.cms.dto.BedStatusDTO;
import com.clinic.cms.entity.AssignBed;

public interface AssignBedRepository extends JpaRepository<AssignBed, Long>{
    
    AssignBed findByBed_BedIdAndDischargedAtIsNull(Long bedId);

    @Query("SELECT new com.clinic.cms.dto.BedStatusDTO( " +
       "ab.bed.bedId, " +
       "ab.bed.bedNumber, " +
       "ab.bed.status, " +
       "ab.patient.id, " +
       "ab.patient.name, " +
       "ab.patient.age, " +
       "ab.assignedAt, " +
       "ab.patientProblem, " +
       "ab.patient.contact, ab.dischargedAt) " +
       "FROM AssignBed ab")
    List<BedStatusDTO> fetchAllBedStatusHistory();

}
