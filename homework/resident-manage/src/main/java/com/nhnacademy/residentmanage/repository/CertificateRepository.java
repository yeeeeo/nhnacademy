package com.nhnacademy.residentmanage.repository;

import com.nhnacademy.residentmanage.domain.certificate.CertificateDto;
import com.nhnacademy.residentmanage.entity.CertificateIssue;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CertificateRepository extends JpaRepository<CertificateIssue, Long> {
    CertificateDto findFirstByResident_ResidentSerialNumberAndCertificateTypeCode(long serialNumber, String type);
    @Query(value = "select c " +
            "from CertificateIssue c " +
            "join Resident r on c.resident.residentSerialNumber = r.residentSerialNumber " +
            "where c.resident.residentSerialNumber = ?1")
    List<CertificateDto> getCertificateDto(long serialNumber);

    Page<CertificateDto> getAllByResident_ResidentSerialNumber(Pageable pageable, long serialNumber);
}
