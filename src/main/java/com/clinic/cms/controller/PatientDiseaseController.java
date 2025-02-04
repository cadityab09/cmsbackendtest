package com.clinic.cms.controller;

import com.clinic.cms.entity.PatientDisease;
import com.clinic.cms.service.PatientDiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/patientdisease")
@CrossOrigin(origins = "http://localhost:3000") // Adjust for your React app's port
public class PatientDiseaseController {

    @Autowired
    private PatientDiseaseService patientDiseaseService;

    // Add a new patient
    @PostMapping
    public PatientDisease addPatient(@RequestBody PatientDisease patientDisease) {
        return patientDiseaseService.addPatient(patientDisease);
    }

    // Get all patients
    @GetMapping
    public List<PatientDisease> getAllPatients() {
        return patientDiseaseService.getAllPatients();
    }
}