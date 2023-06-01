package com.nhnacademy.residentmanage.domain.birth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class BirthRegisterRequest {
    @NotBlank
    private String birthReportDate;
    @NotBlank
    private String birthName;
    @NotBlank
    private String birthGender;
    @NotBlank
    private String birthDate;
    @NotBlank
    private String birthPlace;
    @NotBlank
    private String registrationBaseAddress;
    @NotBlank
    private String fatherName;
    @NotBlank
    private String fatherRegistrationNumber;
    @NotBlank
    private String motherName;
    @NotBlank
    private String motherRegistrationNumber;
    @NotBlank
    private String reportRelationShip;
    private String reportEmailAddress;
    @NotBlank
    private String reportPhoneNumber;
}
