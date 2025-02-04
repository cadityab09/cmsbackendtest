package com.clinic.cms.service;

import com.clinic.cms.entity.PatientDisease;
import com.clinic.cms.repository.PatientDiseaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientDiseaseService {
    @Autowired
    private PatientDiseaseRepository patientDiseaseRepository;

    public PatientDisease addPatient(PatientDisease patientDisease) {
        
        return patientDiseaseRepository.save(patientDisease);
    }

    public List<PatientDisease> getAllPatients() {
        return patientDiseaseRepository.findAll();
    }
}