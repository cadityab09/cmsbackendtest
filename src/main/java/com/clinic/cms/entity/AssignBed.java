package com.clinic.cms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.clinic.cms.enums.BedStatus;

@Entity
@Data
public class AssignBed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bed_id", nullable = false)
    private Bed bed;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDateTime assignedAt;

    private LocalDateTime dischargedAt;  // Will be NULL until discharged

    private String patientProblem;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private BedStatus status;  
}
