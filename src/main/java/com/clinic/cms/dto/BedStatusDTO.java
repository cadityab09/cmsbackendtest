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

	public Long getBedId() {
		return bedId;
	}

	public void setBedId(Long bedId) {
		this.bedId = bedId;
	}

	public Long getBedNumber() {
		return bedNumber;
	}

	public void setBedNumber(Long bedNumber) {
		this.bedNumber = bedNumber;
	}

	public BedStatus getStatus() {
		return status;
	}

	public void setStatus(BedStatus status) {
		this.status = status;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public Integer getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(Integer patientAge) {
		this.patientAge = patientAge;
	}

	public LocalDateTime getAssignedAt() {
		return assignedAt;
	}

	public void setAssignedAt(LocalDateTime assignedAt) {
		this.assignedAt = assignedAt;
	}

	public String getPatientProblem() {
		return patientProblem;
	}

	public void setPatientProblem(String patientProblem) {
		this.patientProblem = patientProblem;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public LocalDateTime getDischargedAt() {
		return dischargedAt;
	}

	public void setDischargedAt(LocalDateTime dischargedAt) {
		this.dischargedAt = dischargedAt;
	}

    // Getters and Setters
}
