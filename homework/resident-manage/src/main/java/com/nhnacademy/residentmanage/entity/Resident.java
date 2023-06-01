package com.nhnacademy.residentmanage.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Resident {
    @Id
    @Column(name = "resident_serial_number")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long residentSerialNumber;
    private String name;
    @Column(name = "resident_registration_number")
    private String residentRegistrationNumber;
    @Column(name = "gender_code")
    private String genderCode;
    @Column(name = "birth_date")
    private LocalDateTime birthDate;
    @Column(name = "birth_place_code")
    private String birthPlaceCode;
    @Column(name = "registration_base_address")
    private String registrationBaseAddress;
    @Column(name = "death_date")
    private LocalDateTime deathDate;
    @Column(name = "death_place_code")
    private String deathPlaceCode;
    @Column(name = "death_place_address")
    private String deathPlaceAddress;

    @OneToMany(mappedBy = "resident")
    private List<BirthDeathReportResident> birthDeathResidents;
    @OneToMany(mappedBy = "reportResident")
    private List<BirthDeathReportResident> birthDeathReportResidents;
    @OneToMany(mappedBy = "baseResident")
    private List<FamilyRelationship> FamilyRelationshipBaseResidents;
    @OneToMany(mappedBy = "familyResident")
    private List<FamilyRelationship> FamilyRelationshipFamilyResidents;
    @OneToMany(mappedBy = "householdResident")
    private List<Household> householdResidents;
    @OneToMany(mappedBy = "resident")
    private List<HouseholdCompositionResident> householdCompositionResidents;
    @OneToMany(mappedBy = "resident")
    private List<CertificateIssue> certificateIssues;
}
