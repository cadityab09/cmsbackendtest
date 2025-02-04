package com.clinic.cms.controller;

import com.clinic.cms.entity.Doctor;
import com.clinic.cms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from React frontend
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public Doctor addOrUpdateDoctor(@RequestBody Doctor doctor) {
        return doctorService.saveOrUpdateDoctor(doctor);
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }
    
}
