package com.clinic.cms.dto;

import java.time.LocalDateTime;

import com.clinic.cms.enums.BedStatus;

import lombok.Data;

@Data
public class BedStatusDTO {
    private Long bedId;
    private Long bedNumber;
    private BedStatus status;
    private Long patientId;
    private String patientName;
    private Integer patientAge;
    private LocalDateTime assignedAt;
    private String patientProblem;
    private String mobileNumber;
    private LocalDateTime dischargedAt;

    // Constructor
    public BedStatusDTO(Long bedId, Long bedNumber, BedStatus status,
                        Long patientId, String patientName, Integer patientAge,
                        LocalDateTime assignedAt, String patientProblem, String mobileNumber, LocalDateTime dischargedAt) {
        this.bedId = bedId;
        this.bedNumber = bedNumber;
        this.status =status;
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientAge = patientAge;
        this.assignedAt = assignedAt;
        this.patientProblem = patientProblem;
        this.mobileNumber = mobileNumber;
        this.dischargedAt = dischargedAt;
    }

    // Getters and Setters
}
