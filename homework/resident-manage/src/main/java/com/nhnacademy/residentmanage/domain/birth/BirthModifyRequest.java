package com.nhnacademy.residentmanage.domain.birth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class BirthModifyRequest {
    @NotBlank
    private String birthReportDate;
    private String birthName;
    private String birthGender;
    private String birthDate;
    private String birthPlace;
    private String registrationBaseAddress;
    private String fatherName;
    private String fatherRegistrationNumber;
    private String motherName;
    private String motherRegistrationNumber;
    private String reportRelationShip;
    private String reportEmailAddress;
    private String reportPhoneNumber;
}
