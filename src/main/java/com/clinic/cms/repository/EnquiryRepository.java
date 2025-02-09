package com.clinic.cms.repository;

//public interface EnquiryRepository {
//}

import com.clinic.cms.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquiryRepository extends JpaRepository<Enquiry, Long> {


}
