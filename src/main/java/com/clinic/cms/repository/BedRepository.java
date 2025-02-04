package com.clinic.cms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.clinic.cms.dto.BedStatusDTO;
import com.clinic.cms.entity.AssignBed;
import com.clinic.cms.entity.Bed;

@Repository
public interface BedRepository extends JpaRepository<Bed, Long> {

    @Query("SELECT new com.clinic.cms.dto.BedStatusDTO(b.bedId, b.bedNumber, b.status, p.id, p.name, p.age, ab.assignedAt, ab.patientProblem, p.contact, ab.dischargedAt) "
            + "FROM Bed b " + "LEFT JOIN AssignBed ab ON b.id = ab.bed.bedId AND ab.dischargedAt IS NULL "
            + "LEFT JOIN Patient p ON ab.patient.id = p.id")
    List<BedStatusDTO> fetchBedStatusWithPatientInfo();

    // @Query("SELECT ab FROM AssignBed ab WHERE ab.patient.id = :patientId ORDER BY ab.assignedAt DESC")
    // AssignBed findAssignmentHistoryByPatientId(Long patientId);
}
