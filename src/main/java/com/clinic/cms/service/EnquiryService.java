package com.clinic.cms.service;

//public class EnquiryService {
//}

import com.clinic.cms.entity.Enquiry;
import com.clinic.cms.repository.EnquiryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnquiryService {

    private final EnquiryRepository enquiryRepository;

    // Constructor-based injection (Best Practice)
    public EnquiryService(EnquiryRepository enquiryRepository) {
        this.enquiryRepository = enquiryRepository;
    }

    // Add Enquiry
    public Enquiry saveEnquiry(Enquiry enquiry) {
        return enquiryRepository.save(enquiry);
    }

    // view  all Enquiries
    public List<Enquiry> getAllEnquiries() {
        return enquiryRepository.findAll();
    }
}