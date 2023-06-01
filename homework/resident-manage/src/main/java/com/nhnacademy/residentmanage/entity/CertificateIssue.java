package com.nhnacademy.residentmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Certificate_Issue")
public class CertificateIssue {
    @Id
    @Column(name = "certificate_confirmation_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long certificateConfirmationNumber;

    @ManyToOne
    @JoinColumn(name = "resident_serial_number")
    private Resident resident;

    @Column(name = "certificate_type_code")
    private String certificateTypeCode;
    @Column(name = "certificate_issue_date")
    private LocalDate certificateIssueDate;
}
