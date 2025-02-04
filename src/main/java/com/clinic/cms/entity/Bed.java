package com.clinic.cms.entity;

import com.clinic.cms.enums.BedStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Bed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bedId;

    @Column(unique = true, nullable = false)
    private Long bedNumber;
    
    @Enumerated(EnumType.STRING)
    private BedStatus status;
}
