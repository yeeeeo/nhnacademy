package com.nhnacademy.residentmanage.domain.certificate;

import com.nhnacademy.residentmanage.entity.Resident;

import java.time.LocalDate;

public interface CertificateDto {
    long getCertificateConfirmationNumber();
    Resident getResident();
    String getCertificateTypeCode();
    LocalDate getCertificateIssueDate();
}
