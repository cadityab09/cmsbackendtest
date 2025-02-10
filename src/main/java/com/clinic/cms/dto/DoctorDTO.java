package com.clinic.cms.dto;

import java.util.List;
import com.clinic.cms.enums.DoctorStatus;

public class DoctorDTO {
    private Long id;
    private String name;
    private String specialties;
    private String inTime;
    private String outTime;
    private List<String> days; // List of available days
    private DoctorStatus doctorStatus;

    // No-args constructor
    public DoctorDTO() {}

    // All-args constructor
    public DoctorDTO(Long id, String name, String specialties, String inTime, String outTime, List<String> days, DoctorStatus doctorStatus) {
        this.id = id;
        this.name = name;
        this.specialties = specialties;
        this.inTime = inTime;
        this.outTime = outTime;
        this.days = days;
        this.doctorStatus = doctorStatus;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialties() {
        return specialties;
    }

    public void setSpecialties(String specialties) {
        this.specialties = specialties;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public List<String> getDays() {
        return days;
    }

    public void setDays(List<String> days) {
        this.days = days;
    }

    public DoctorStatus getDoctorStatus() {
        return doctorStatus;
    }

    public void setDoctorStatus(DoctorStatus doctorStatus) {
        this.doctorStatus = doctorStatus;
    }
}
