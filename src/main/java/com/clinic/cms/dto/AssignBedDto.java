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
    

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public LocalDateTime getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public LocalDateTime getDischargedAt() {
		return dischargedAt;
	}

	public void setDischargedAt(LocalDateTime dischargedAt) {
		this.dischargedAt = dischargedAt;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public BedStatus getStatus() {
		return bedStatus;
	}

	public void setStatus(BedStatus status) {
		this.bedStatus = status;
	}

	private Long id;

    private Long bedId;

    private Long patientId;

    private LocalDateTime assignedAt;

    private LocalDateTime dischargedAt;  // Will be NULL until discharged

    private String patientProblem;
    
    @Enumerated(EnumType.STRING)
    private BedStatus bedStatus;  
}
