package com.nhnacademy.residentmanage.domain.death;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
public class DeathRegisterRequest {
    @NotBlank
    private String deathReportDate;
    @NotBlank
    private String deathName;
    @NotBlank
    private String deathRegistrationNumber;
    @NotBlank
    private String deathDate;
    @NotBlank
    private String deathPlace;
    @NotBlank
    private String deathPlaceAddress;
    @NotBlank
    private String reportRelationShip;
    private String reportEmailAddress;
    @NotBlank
    private String reportPhoneNumber;
}
