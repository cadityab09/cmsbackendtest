package com.clinic.cms.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clinic.cms.dto.AssignBedDto;
import com.clinic.cms.dto.BedStatusDTO;
import com.clinic.cms.entity.Bed;
import com.clinic.cms.enums.BedStatus;
import com.clinic.cms.repository.BedRepository;
import com.clinic.cms.service.BedService;

import lombok.AllArgsConstructor;
import lombok.Data;


@RestController
@RequestMapping("/api/beds")
@Data
@AllArgsConstructor
@CrossOrigin("*")
public class BedController {
    
    private BedService bedService;

    private BedRepository bedRepository;

    @PostMapping("/assign")
    public ResponseEntity<AssignBedDto> AssignBedToPatient(@RequestBody AssignBedDto assignBedDto) {
        return ResponseEntity.ok(bedService.assignBedService(assignBedDto));
    }

    @GetMapping("/status")
    public ResponseEntity<List<BedStatusDTO>> getBedStatus() {
        List<BedStatusDTO> bedStatus = bedService.getBedStatus();

        return ResponseEntity.ok(bedStatus);
    }

    @PostMapping("/discharge")
    public ResponseEntity<BedStatusDTO> dischargeBed(@RequestBody BedStatusDTO bedStatusDTO) {
         bedService.dischargePatientFromBed(bedStatusDTO);

        return ResponseEntity.ok(bedStatusDTO);
    }

    @GetMapping("/history")
    public ResponseEntity<List<BedStatusDTO>> getBedHistory() {
        List<BedStatusDTO> bedHistoryList = bedService.getBedHistory();

        return ResponseEntity.ok(bedHistoryList);
    }
}
