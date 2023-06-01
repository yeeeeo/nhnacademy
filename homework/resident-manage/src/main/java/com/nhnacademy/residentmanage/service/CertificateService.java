package com.nhnacademy.residentmanage.service;

import com.nhnacademy.residentmanage.domain.certificate.CertificateDto;
import com.nhnacademy.residentmanage.entity.CertificateIssue;
import com.nhnacademy.residentmanage.entity.Resident;
import com.nhnacademy.residentmanage.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class CertificateService {
    private final CertificateRepository certificateRepository;
    private final ResidentService residentService;

    public CertificateDto getFamilyRelationshipCertificateIssue(long serialNumber){
        return certificateRepository.findFirstByResident_ResidentSerialNumberAndCertificateTypeCode(serialNumber, "가족관계증명서");
    }

    public CertificateDto getResidentRegistrationCertificateIssue(long serialNumber){
        return certificateRepository.findFirstByResident_ResidentSerialNumberAndCertificateTypeCode(serialNumber, "주민등록등본");
    }

    public List<CertificateDto> getCertificateDto(long serialNumber){
        return certificateRepository.getCertificateDto(serialNumber);
    }

    public Page<CertificateDto> getCertificatePage(Pageable pageable, long serialNumber){
        return certificateRepository.getAllByResident_ResidentSerialNumber(pageable, serialNumber);
    }

    @Transactional
    public void registerCertificate(long serialNumber, String type, LocalDate date){
        Resident resident = residentService.getResidentBySerialNumber(serialNumber);
        CertificateIssue certificateIssue = new CertificateIssue();
        certificateIssue.setResident(resident);
        certificateIssue.setCertificateTypeCode(type);
        certificateIssue.setCertificateIssueDate(date);
        certificateRepository.saveAndFlush(certificateIssue);
    }
}
