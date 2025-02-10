package com.clinic.cms.controller;

//public class EnquiryController {
//}

import com.clinic.cms.entity.Enquiry;
import com.clinic.cms.service.EnquiryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/enquiry")
@CrossOrigin("*")
public class EnquiryController {

    @Autowired
    private EnquiryService enquiryService;

    // @PostMapping()
    @PostMapping("/add")
    public ResponseEntity<Enquiry> addEnquiry(@RequestBody Enquiry enquiry) {
        Enquiry savedEnquiry = enquiryService.saveEnquiry(enquiry);
        return ResponseEntity.ok(savedEnquiry);
    }

    @GetMapping("/view")
    public ResponseEntity<List<Enquiry>> viewEnquiries() {
        List<Enquiry> enquiries = enquiryService.getAllEnquiries();
        return ResponseEntity.ok(enquiries);
    }
    @PutMapping("/update")
    public ResponseEntity<Enquiry> updateEnquiries(@RequestBody Enquiry enquiry) {
        enquiry = enquiryService.updateEnquiry(enquiry);
        return ResponseEntity.ok(enquiry);
    }
}
