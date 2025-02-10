package com.clinic.cms.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clinic.cms.dto.AssignBedDto;
import com.clinic.cms.dto.BedStatusDTO;
import com.clinic.cms.entity.AssignBed;
import com.clinic.cms.entity.Bed;
import com.clinic.cms.entity.Patient;
import com.clinic.cms.enums.BedStatus;
import com.clinic.cms.repository.AssignBedRepository;
import com.clinic.cms.repository.BedRepository;
import com.clinic.cms.repository.PatientRepository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Service
public class BedService {

    private BedRepository bedRepository;

    private AssignBedRepository assignBedRepository;

    private PatientRepository patientRepository;

    public AssignBedDto assignBedService(AssignBedDto assignBedDto) {

        Bed bed = bedRepository.getById(assignBedDto.getBedId());

        Patient patient = patientRepository.getById(assignBedDto.getPatientId());

        AssignBed assignBed = null;
        if (bed != null && patient != null) {
            assignBed = new AssignBed();
            assignBed.setBed(bed);
            assignBed.setPatient(patient);
            assignBed.setStatus(BedStatus.UNAVAILABLE);
            assignBed.setAssignedAt(LocalDateTime.now());
            assignBed.setPatientProblem(assignBedDto.getPatientProblem());
            assignBedRepository.save(assignBed);

            bed.setStatus(BedStatus.UNAVAILABLE);

            bedRepository.save(bed);

            assignBedDto.setStatus(BedStatus.UNAVAILABLE);
        } else {
            System.out.println("Null value at bed service");
        }

        System.out.println(assignBedDto);
        return assignBedDto;
    }

    public List<BedStatusDTO> getBedStatus() {
        return bedRepository.fetchBedStatusWithPatientInfo();
    }
    public List<BedStatusDTO> getBedHistory() {

        List<BedStatusDTO> bedHistoryList = assignBedRepository.fetchAllBedStatusHistory();

        return bedHistoryList;
    }

    public BedStatusDTO dischargePatientFromBed(BedStatusDTO bedStatusDTO) {

        System.out.println(bedStatusDTO);

        AssignBed assignBed = assignBedRepository.findByBed_BedIdAndDischargedAtIsNull(bedStatusDTO.getBedId());

        if (assignBed != null) {
            // Update dischargedAt and status
            assignBed.setDischargedAt(LocalDateTime.now());
            assignBed.setStatus(BedStatus.AVAILABLE);
            assignBedRepository.save(assignBed);

            // Update bed status to AVAILABLE
            Bed bed = assignBed.getBed();
            bed.setStatus(BedStatus.AVAILABLE);
            bedRepository.save(bed);

            bedStatusDTO.setStatus(BedStatus.AVAILABLE);
            return bedStatusDTO;
        }
        throw new RuntimeException("Record not found");
    }
}
