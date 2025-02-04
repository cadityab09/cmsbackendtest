package com.clinic.cms.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

import com.clinic.cms.enums.DoctorStatus;

@Entity
@Data
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String img; // Base64 string for the image

    private String name;

    private String specialties;

    private String inTime;

    private String outTime;

    @ElementCollection
    private List<String> days; // List of available days

    private DoctorStatus status;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getImg() { return img; }
    public void setImg(String img) { this.img = img; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSpecialties() { return specialties; }
    public void setSpecialties(String specialties) { this.specialties = specialties; }

    public String getInTime() { return inTime; }
    public void setInTime(String inTime) { this.inTime = inTime; }

    public String getOutTime() { return outTime; }
    public void setOutTime(String outTime) { this.outTime = outTime; }

    public List<String> getDays() { return days; }
    public void setDays(List<String> days) { this.days = days; }
}
