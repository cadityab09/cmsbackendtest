package com.clinic.cms.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.clinic.cms.enums.BedStatus;

@Entity
@Data
public class AssignBed {

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Bed getBed() {
		return bed;
	}

	public void setBed(Bed bed) {
		this.bed = bed;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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
		return status;
	}

	public void setStatus(BedStatus status) {
		this.status = status;
	}

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
