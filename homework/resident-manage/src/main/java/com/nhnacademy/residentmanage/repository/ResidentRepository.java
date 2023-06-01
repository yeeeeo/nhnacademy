package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.resident.ResidentDto;
import com.nhnacademy.residentmanage.entity.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResidentRepository extends JpaRepository<Resident, Long> {
    Resident findByResidentSerialNumber(long serialNumber);
    Resident findByNameAndResidentRegistrationNumber(String name, String residentRegistrationNumber);
    Resident findByName(String name);
    Page<ResidentDto> getAllBy(Pageable pageable);

}
