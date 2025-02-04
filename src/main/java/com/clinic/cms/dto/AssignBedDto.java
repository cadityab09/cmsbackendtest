package com.clinic.cms.dto;

import java.time.LocalDateTime;

import com.clinic.cms.entity.Bed;
import com.clinic.cms.entity.Patient;
import com.clinic.cms.enums.BedStatus;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
public class AssignBedDto {
    

    private Long id;

    private Long bedId;

    private Long patientId;

    private LocalDateTime assignedAt;

    private LocalDateTime dischargedAt;  // Will be NULL until discharged

    private String patientProblem;
    
    @Enumerated(EnumType.STRING)
    private BedStatus status;  
}
