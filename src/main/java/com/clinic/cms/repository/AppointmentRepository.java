package com.clinic.cms.repository;

//public interface AppointmentRepository {
//}

import com.clinic.cms.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {

}