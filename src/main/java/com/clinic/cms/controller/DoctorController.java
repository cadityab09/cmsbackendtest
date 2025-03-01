package com.clinic.cms.controller;

import com.clinic.cms.dto.DoctorDTO;
import com.clinic.cms.entity.Doctor;
import com.clinic.cms.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/doctors")
@CrossOrigin("*")
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
    @GetMapping("/lightly")
    public List<Doctor> getAllDoctorsLightly() {
        return doctorService.getAllDoctorsLightly();
    }
    
}
