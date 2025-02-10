package com.clinic.cms.service;

import com.clinic.cms.dto.DoctorDTO;
import com.clinic.cms.entity.Doctor;
import com.clinic.cms.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    @Autowired
    private DoctorRepository doctorRepository;

    public Doctor saveOrUpdateDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }
    public List<Doctor> getAllDoctorsLightly() {
        List<Doctor> doctorList =  doctorRepository.findAll();
        doctorList.forEach(doctor -> doctor.setImg(""));
        return doctorList;
    }
}
