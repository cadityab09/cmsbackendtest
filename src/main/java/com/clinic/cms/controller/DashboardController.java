package com.clinic.cms.controller;

import com.clinic.cms.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
@CrossOrigin("*")
public class DashboardController {

    @Autowired
    private PatientRepository patientRepository;

    // Endpoint to get the number of patients
    @GetMapping("/patients-count")
    public long getPatientsCount() {
        return patientRepository.count();  // Returns the total number of patients in the database
    }
}
